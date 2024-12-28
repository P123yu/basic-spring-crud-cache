package com.redis.spring_redis.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Table(name="_user")

// it is important to make entity serializable to perform save operation on redis

public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
}
