package pt.isban.cib.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import pt.isban.cib.annotations.ValidaClienteInput;
import pt.isban.cib.entity.Cliente;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

// DTO da classe cliente
@ValidaClienteInput
public class ClienteNewDTO {

    @NotNull(message = "O email nao pode ser vazio")
    @Email(message = "Email nao é valido")
    private String email;

    @NotNull(message = "A palavra-passe não pode ser vazia")
    private String password;

    @NotNull(message = "O nome não pode ser vazio")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dtNasc;

    public ClienteNewDTO() {}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

}
