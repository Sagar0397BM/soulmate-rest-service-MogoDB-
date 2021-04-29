package com.stackroute.soulMateDemo.Domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "users")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String gender;
    private int age;


}
