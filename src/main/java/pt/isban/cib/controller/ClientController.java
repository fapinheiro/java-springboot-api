package pt.isban.cib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.isban.cib.entity.Cliente;
import pt.isban.cib.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private ClienteService clienteService;

    // GET
    @GetMapping(path = "/clientes")
    public ResponseEntity<List<Cliente>> getClientesAtivos() {
        List<Cliente> list = clienteService.getClientes();
        return ResponseEntity.status(HttpStatus.OK)
                    .body(list);
    }

    // POST

    // PUT

    // DELETE

}
