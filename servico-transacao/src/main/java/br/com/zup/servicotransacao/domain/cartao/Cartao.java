package br.com.zup.servicotransacao.domain.cartao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cartao {
    @Id
    @NotBlank
    private String id;
    @Email
    @NotBlank
    private String email;

    @Deprecated
    public Cartao() {}

    public Cartao(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }
}