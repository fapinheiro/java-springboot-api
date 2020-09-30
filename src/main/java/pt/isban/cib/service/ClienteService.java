package pt.isban.cib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import pt.isban.cib.dto.ClienteDTO;
import pt.isban.cib.dto.ClienteNewDTO;
import pt.isban.cib.entity.Cliente;
import pt.isban.cib.entity.Morada;
import pt.isban.cib.entity.Privilegio;
import pt.isban.cib.enums.PrivilegioEnum;
import pt.isban.cib.exception.NotFoundException;
import pt.isban.cib.repository.ClienteRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


// Classe que contem a lógica de negócio
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteDAO;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public List<Cliente> getClientes() {
        List<Cliente> list = new ArrayList<>();
        clienteDAO.findAll().forEach( cliente -> {

            // Incluir somente clientes ativos
            if (cliente.getAtivo()) {
                list.add(cliente);
            }

        });
        return list;
    }

    public List<Cliente> getClientesByNome(String nome) {
        return clienteDAO.findByNomeContaining(nome);
    }

    public List<Cliente> getClientesByEmail(String email) {
        return clienteDAO.findByEmail(email.toLowerCase());
    }

    public Cliente getClienteByID(Integer id) throws Throwable {
        return clienteDAO.findById(id)
                .orElseThrow( () -> {
                    throw new NotFoundException(
                            String.format("Um cliente de ID {%d} não foi encontrado", id));
                });
    }

    public ClienteDTO saveDTO(ClienteNewDTO dto) {
        Cliente cliente = new Cliente(dto);
        cliente.setAtivo(true);

        final Date currentDate = new Date();
        cliente.setDataCriacao(currentDate);

        // Definir campos de morada
        Morada morada = cliente.getMorada();
        morada.setDtCriacao( currentDate );
        morada.setCliente(cliente);

        // Definir lista de documentos
        cliente.getDocList().forEach( doc -> {
            doc.setDtCriacao(currentDate);
            doc.setCliente(cliente);
        });

        // Definir default role
        List<PrivilegioEnum> list = new ArrayList<>();
        list.add(PrivilegioEnum.CLIENT);
        cliente.setRoles(list);

        // Codificar a password
        cliente.setPassword( encoder.encode(cliente.getPassword()) );

        Cliente clienteNew = clienteDAO.save( cliente );

        return new ClienteDTO(clienteNew);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, timeout = 5) //timeout em segundos
    public void removerClientePorID(Integer id) throws Throwable {
        clienteDAO.findById(id).map(client -> {
            clienteDAO.deleteById(id);
            return client;
        }).orElseThrow(() -> {
            throw new NotFoundException(
                    String.format("Um cliente de ID {%d} não foi encontrado", id));
        });
    }

    @Transactional(isolation = Isolation.SERIALIZABLE, timeout = 5) //timeout em segundos
    public ClienteDTO updateDTO(Integer id, ClienteNewDTO dto) throws Throwable {
        return clienteDAO.findById(id).map(client -> {

            // Filtering
            if (dto.getPassword() != null) {
                client.setPassword(dto.getPassword());
            }

            if (dto.getDtNasc()  != null ) {
                client.setDataNascimento(dto.getDtNasc());
            }

            if (dto.getNome()  != null) {
                client.setNome(dto.getNome());
            }

            if (dto.getEmail() != null) {
                client.setEmail(dto.getEmail());
            }

            client.setDataAtualizacao( new Date());
            return new ClienteDTO(clienteDAO.save(client));
        }).orElseThrow(() -> {
            throw new NotFoundException(
                    String.format("Um cliente de ID {%d} não foi encontrado", id));
        });
    }
}
