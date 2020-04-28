package pt.isban.cib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.isban.cib.dto.ClienteDTO;
import pt.isban.cib.entity.Cliente;
import pt.isban.cib.service.ClienteService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private ClienteService clienteService;

    // GET
    @GetMapping(path = "/clientes")
    public ResponseEntity<List<ClienteDTO>> getClientesAtivos(
            @RequestParam(required=false, defaultValue = "") String nome,
            @RequestParam(required=false, defaultValue = "") String email
    ){

        List<Cliente> list = new ArrayList<>();

        if (!"".equals(nome)) {
            list.addAll(clienteService.getClientesByNome(nome));
        } else if (!"".equals(email)) {
            list.addAll(clienteService.getClientesByEmail(email));
        } else {
            list.addAll(clienteService.getClientes());
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(list.stream()
                        .map( cliente -> new ClienteDTO(cliente))
                        .collect(Collectors.toList()));

    }

//    @GetMapping(path = "/clientes")
//    public ResponseEntity<List<Cliente>> getClientesAtivos() {
//        List<Cliente> list = clienteService.getClientes();
//        return ResponseEntity.status(HttpStatus.OK)
//                    .body(list);
//    }

    // POST

    // PUT

    // DELETE

}
