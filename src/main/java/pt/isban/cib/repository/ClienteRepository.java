package pt.isban.cib.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pt.isban.cib.entity.Cliente;

import java.util.List;

// Objecto de acesso ao banco de dados  DAO (Data Access Object)
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    // Like findByPlaceLike
    // StartingWith findByPlaceStartingWith
    // EndingWith findByPlaceEndingWith
    // Containing findByPlaceContaining
    List<Cliente> findByNomeContaining(String nome);

    @Query(value = "select * from clients c where lower(c.email) like %?1%",
            nativeQuery = true)
    List<Cliente> findByEmail(String email);

}
