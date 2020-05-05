package pt.isban.cib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.isban.cib.dto.ClienteDTO;
import pt.isban.cib.dto.ClienteNewDTO;
import pt.isban.cib.entity.Cliente;
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
                    throw new NotFoundException("Cliente não encontrado");
                });
    }

    public ClienteDTO saveDTO(ClienteNewDTO dto) {
        Cliente cliente = new Cliente(dto);
        cliente.setAtivo(true);
        cliente.setDataCriacao(new Date());
        Cliente clienteNew = clienteDAO.save( cliente );
        return new ClienteDTO(clienteNew);
    }
}
