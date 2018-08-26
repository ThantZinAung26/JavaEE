package ru.zakharov.enterprise.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
public class User extends AbstractEntity{

    @Getter
    @Setter
    private String login;

    @Getter
    @Setter
    private String passwd;

    @Getter
    @Setter
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Group> groups;

    @Getter
    @Setter
    @ManyToOne
    private Role role;


}
