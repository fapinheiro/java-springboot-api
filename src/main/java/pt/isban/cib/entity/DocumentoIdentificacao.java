package pt.isban.cib.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="identifications")
@SequenceGenerator(sequenceName="seq_identifications", name = "seq_identifications")
public class DocumentoIdentificacao {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_identifications")
    @Column( name="identification_id")
    private Integer documentoIdentificacaoId;

    @NotNull
    @Column(name="ident_type")
    private Integer tipoDoDocumento;

    @NotNull
    @Column(name="ident_type")
    @Max(value=100)
    private String numeroDocumento;

    @NotNull
    @Column(name = "emission_date")
    @Temporal(TemporalType.DATE)
    private Date dtEmissao;

    @NotNull
    @Column(name = "valid_date")
    @Temporal(TemporalType.DATE)
    private Date dtValidate;

    @NotNull
    @Column(name = "creation_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtCriacao;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtActualizacao;

    @JsonIgnore
    @NotNull
    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Cliente client;

    public Integer getDocumentoIdentificacaoId() {
        return documentoIdentificacaoId;
    }

    public void setDocumentoIdentificacaoId(Integer documentoIdentificacaoId) {
        this.documentoIdentificacaoId = documentoIdentificacaoId;
    }

    public Integer getTipoDoDocumento() {
        return tipoDoDocumento;
    }

    public void setTipoDoDocumento(Integer tipoDoDocumento) {
        this.tipoDoDocumento = tipoDoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Date getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Date dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public Date getDtValidate() {
        return dtValidate;
    }

    public void setDtValidate(Date dtValidate) {
        this.dtValidate = dtValidate;
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

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
}
