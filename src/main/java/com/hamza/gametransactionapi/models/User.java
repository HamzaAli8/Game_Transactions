package com.hamza.gametransactionapi.models;


import lombok.*;

import javax.naming.Name;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // show a one to many relationship between user and transactions

    private Long userId;

    private String name;

    private String emailAddress;
}
