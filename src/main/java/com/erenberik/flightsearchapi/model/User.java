package com.erenberik.flightsearchapi.model;

import jakarta.persistence.*;
import lombok.*;

//todo: remove getter setter after jwt auth
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users") //PostgreSQL don't allow user as table name
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

}
