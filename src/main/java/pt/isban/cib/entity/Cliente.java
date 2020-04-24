package pt.isban.cib.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
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
    private String email;

    //private String password;

    @Column(name = "name")
    private String nome;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name = "creation_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    //@Type(type="true_false")
    @Column(name = "active")
    private Boolean ativo;

    // TODO criar endereco

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
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
       this.ativo = ativo;
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
