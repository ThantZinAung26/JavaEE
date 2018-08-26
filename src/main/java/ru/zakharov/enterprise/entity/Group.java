package ru.zakharov.enterprise.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;


@Entity
public class Group extends AbstractEntity{

    @Getter
    @Setter
    @ManyToOne
    private User user;





}
