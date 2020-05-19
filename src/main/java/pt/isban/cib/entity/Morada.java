package pt.isban.cib.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name="addresses")
@SequenceGenerator(sequenceName="seq_addresses", name = "seq_addresses")
public class Morada {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_clients")
    @Column( name="address_id")
    private Integer moradaId;

    @NotNull
    @Max(value = 100)
    @Column(name = "street_name")
    private String endereco;

    @NotNull
    @Max(value = 100)
    @Column(name = "street_complement")
    private String enderecoComplement;

    @NotNull
    @Column(name = "creation_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCriacao;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtActualizacao;

    public Integer getMoradaId() {
        return moradaId;
    }

    public void setMoradaId(Integer moradaId) {
        this.moradaId = moradaId;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEnderecoComplement() {
        return enderecoComplement;
    }

    public void setEnderecoComplement(String enderecoComplement) {
        this.enderecoComplement = enderecoComplement;
    }

    public Date getDtCriacao() {
        return dtCriacao;
    }

    public void setDtCriacao(Date dtCriacao) {
        this.dtCriacao = dtCriacao;
    }

    public Date getDtActualizacao() {
        return dtActualizacao;
    }

    public void setDtActualizacao(Date dtActualizacao) {
        this.dtActualizacao = dtActualizacao;
    }
}
