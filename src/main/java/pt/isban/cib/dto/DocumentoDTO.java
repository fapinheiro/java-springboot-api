package pt.isban.cib.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import pt.isban.cib.entity.DocumentoIdentificacao;
import pt.isban.cib.enums.TiposDeDocumentoEnum;

import java.util.Date;

public class DocumentoDTO {

    private TiposDeDocumentoEnum tipo;
    private String numero;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dtEmissao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dtValidade;

    public DocumentoDTO() {}

    public DocumentoDTO(DocumentoIdentificacao entity) {
        this.tipo = TiposDeDocumentoEnum.toEnum(entity.getTipoDoDocumento());
        this.numero = entity.getNumeroDocumento();
        this.dtEmissao = entity.getDtEmissao();
        this.dtValidade = entity.getDtValidate();
    }

    public TiposDeDocumentoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TiposDeDocumentoEnum tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Date getDtEmissao() {
        return dtEmissao;
    }

    public void setDtEmissao(Date dtEmissao) {
        this.dtEmissao = dtEmissao;
    }

    public Date getDtValidade() {
        return dtValidade;
    }

    public void setDtValidade(Date dtValidade) {
        this.dtValidade = dtValidade;
    }
}
