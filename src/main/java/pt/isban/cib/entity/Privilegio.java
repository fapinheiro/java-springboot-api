package pt.isban.cib.entity;

import pt.isban.cib.enums.PrivilegioEnum;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="roles")
public class Privilegio {

    @Id
    @Column(name="role_id")
    private Integer privilegioId;

    @NotNull
    @Column(name="description")
    @Max(value=200)
    private String privilegioDesc;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Cliente> clienteList = new ArrayList<>();

    public Privilegio() {}

    public Privilegio(PrivilegioEnum role) {
        this.privilegioId = role.getCodigo();
        this.privilegioDesc = role.getDescricao();
    }

    public Integer getPrivilegioId() {
        return privilegioId;
    }

    public void setPrivilegioId(Integer privilegioId) {
        this.privilegioId = privilegioId;
    }

    public String getPrivilegioDesc() {
        return privilegioDesc;
    }

    public void setPrivilegioDesc(String privilegioDesc) {
        this.privilegioDesc = privilegioDesc;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }
}
