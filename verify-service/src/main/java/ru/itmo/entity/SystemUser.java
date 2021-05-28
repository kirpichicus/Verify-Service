package ru.itmo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(	name = "system_user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        }, schema= "verify_app")
public class SystemUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @NotBlank
    @Size(max = 20)
    @Column(name="username")
    private String username;

    @NotBlank
    @Size(max = 20)
    @Column(name="name")
    private String name;

    @NotBlank
    @Size(max = 20)
    @Column(name="last_name")
    private String lastName;

    @NotBlank
    @Size(max = 50)
    //@Email
    @Column(name="email")
    private String email;

    @Column(name= "model_name")
    private String modelName;

    public SystemUser(Long userId, String username, String name, String lastName, String email) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
    }

    public SystemUser() {

    }
}