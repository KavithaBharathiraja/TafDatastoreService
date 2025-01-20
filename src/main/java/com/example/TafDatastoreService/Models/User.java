package com.example.TafDatastoreService.Models;

import java.time.LocalDateTime;
//import jakarta.persistence.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String email;
    private String phone;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
