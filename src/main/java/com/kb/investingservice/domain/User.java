package com.kb.investingservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class User {

    /*
    USER_ID							사용자_아이디			PK
    NAME						    사용자_이름
    */

    @Id
    private String userId;


    private String name;

    @OneToMany(mappedBy = "user")
    private List<Purchase> purchases = new ArrayList<>();

}
