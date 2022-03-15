package br.com.endoffile.model.dto;

import br.com.endoffile.model.User;

import javax.validation.constraints.NotEmpty;

public class UserDTO {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String address;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User toUser() {
        User user = new User();
        user.setNome(nome);
        user.setAddress(address);
        return user;
    }
}
