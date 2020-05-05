package pt.isban.cib.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;
import pt.isban.cib.dto.ClienteNewDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

// Classe de representação de objecto do banco de dados
@Entity
@Table(name="clients")
@SequenceGenerator(sequenceName="seq_clients", name = "seq_clients")
public class Cliente {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_clients")
    @Column(name = "client_id")
    private Integer clienteId;

    @NotNull
    @Size(max = 100)
    private String email;

    @NotNull
    @Size(max = 100)
    private String password;

    @NotNull
    @Size(max = 100)
    @Column(name = "name")
    private String nome;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @NotNull
    @Column(name = "creation_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

//    @Type(type="true_false")
    @Column(name = "active")
    private String ativo;

    // TODO criar endereco

    public Cliente() {}

    public Cliente(ClienteNewDTO dto) {
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.nome = dto.getNome();
        this.dataNascimento = dto.getDtNasc();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Boolean getAtivo() {
        if (!"".equals(ativo) && ativo.equals("1")) {
            return true;
        }
        return false;
    }

    public void setAtivo(Boolean ativo) {
        if (ativo == true) {
            this.ativo = "1";
        } else {
            this.ativo = "0";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(clienteId, cliente.clienteId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clienteId);
    }
}
