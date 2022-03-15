package br.com.endoffile.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NamedQuery(name = "User.findByAddress", query = "select user from User user WHERE user.address = :address")
@Entity
public class User{

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @NotEmpty
    private String nome;

    @NotEmpty
    private String address;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

}
