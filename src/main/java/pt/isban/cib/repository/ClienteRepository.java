package pt.isban.cib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.isban.cib.entity.Cliente;

// Objecto de acesso ao banco de dados  DAO (Data Access Object)
@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

}
