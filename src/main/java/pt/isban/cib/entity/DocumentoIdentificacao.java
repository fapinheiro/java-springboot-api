package pt.isban.cib.entity;

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

    // TODO
    private Cliente client;
}
