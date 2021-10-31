package com.intercorp.customers.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor

@Entity(name = "cliente")
public class Customer {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellidos")
    private String surname;

    @Column
    private String email;

    @Column
    private String dni;

    @Column(updatable = false, name="fecha_creacion")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "fecha_nacimiento")
    private LocalDate birthDate;
}
