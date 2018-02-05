package com.roamer.spittr.pojo;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * @author roamer
 * @version V1.0
 * @date 2018/1/12
 */
@Entity
@Table(name = "TBL_SPITTER")
@Data
public class Spitter implements Serializable{

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min = 5, max = 16, message = "{spitter.username.size}")
    @Column(name = "username")
    private String username;

    @NotNull
    @Size(min = 5, max = 20)
    @Column(name = "password")
    private String password;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "firstName")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 30)
    @Column(name = "lastName")
    private String lastName;

    @Pattern(regexp = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?")
    @Transient
    private String email;

    public Spitter() {
    }

    public Spitter(@NotNull @Size(min = 5, max = 16) String username, @NotNull @Size(min = 5, max = 20) String password, @NotNull @Size(min = 2, max = 30) String firstName, @NotNull @Size(min = 2, max = 30) String lastName) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Spitter(Long id, @NotNull @Size(min = 5, max = 16) String username, @NotNull @Size(min = 5, max = 20) String password, @NotNull @Size(min = 2, max = 30) String firstName, @NotNull @Size(min = 2, max = 30) String lastName) {
        this(username, password, firstName, lastName);
        this.id = id;
    }

    public Spitter(Long id, @NotNull @Size(min = 5, max = 16) String username, @NotNull @Size(min = 5, max = 20) String password, @NotNull @Size(min = 2, max = 30) String firstName, @NotNull @Size(min = 2, max = 30) String lastName, @Pattern(regexp = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?") String email) {
        this(id, username, password, firstName, lastName);
        this.email = email;
    }
}
