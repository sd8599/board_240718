package com.boot.board_240718.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private String password;
    private Boolean enabled;

    @ManyToMany
    @JoinTable(
//        테이블이름
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    //    다대다관계구축
//    private List<Role> roles;
    //여러번안돌아가게
    @JsonIgnore
    private List<Role> roles=new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Board> boards =new ArrayList<>();

}
