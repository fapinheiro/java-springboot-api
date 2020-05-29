package pt.isban.cib.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pt.isban.cib.entity.Cliente;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;


public class MoradaDTO {

    private String endereco;

    private String complemento;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
