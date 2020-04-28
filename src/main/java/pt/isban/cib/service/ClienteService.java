package pt.isban.cib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.isban.cib.entity.Cliente;
import pt.isban.cib.repository.ClienteRepository;

import java.util.ArrayList;
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
}
