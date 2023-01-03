package com.study.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Loja {
    @Id
    private int Id;
    private String Name;

    public Loja(){};

    public Loja(int id, String name) {
        Id = id;
        Name = name;
    }


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


}
