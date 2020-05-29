package pt.isban.cib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pt.isban.cib.dto.ClienteDTO;
import pt.isban.cib.dto.ClienteNewDTO;
import pt.isban.cib.entity.Cliente;
import pt.isban.cib.service.ClienteService;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class ClientController {

    @Autowired
    private ClienteService clienteService;

    // GET
    @PreAuthorize("hasAnyRole('ADMIN')")
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

    // GET
    @PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
    @GetMapping(path = "/clientes/{id}")
    public ResponseEntity<ClienteDTO> getClientePorID(@PathVariable Integer id) throws Throwable {
        Cliente cliente = clienteService.getClienteByID(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ClienteDTO(cliente));
    }

    // POST
    @PostMapping(path = "/clientes")
    public ResponseEntity<ClienteDTO> inserirCliente(@Valid @RequestBody ClienteNewDTO dto) throws Throwable {

        ClienteDTO clienteDTO = clienteService.saveDTO(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clienteDTO.getClienteId())
                .toUri();

        return ResponseEntity.created(uri).body(clienteDTO);
    }

    // PUT
    @PreAuthorize("hasAnyRole('CLIENT', 'ADMIN')")
    @PutMapping(path = "/clientes/{id}")
    public ResponseEntity<ClienteDTO> atualizarClientePorID(@PathVariable Integer id,
                                                        @RequestBody ClienteNewDTO dto) throws Throwable {
        ClienteDTO clienteDTO = clienteService.updateDTO(id, dto);
        return  ResponseEntity.status(HttpStatus.OK)
                .body(clienteDTO);
    }

    // DELETE
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping(path = "/clientes/{id}")
    public ResponseEntity<Void> removerClientePorID(@PathVariable Integer id) throws Throwable {
        clienteService.removerClientePorID(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
