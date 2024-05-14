package com.puppiespassion.model;

import com.puppiespassion.model.enums.Gender;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Size(min = 5, max = 30)
    @Column(nullable = false, unique = true)
    private String username;

    @Size(min = 5)
    @Column(nullable = false)
    private String password;

    @Email
    @Column(nullable = false)
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "modification_date")
    private LocalDateTime modificationDate;

    @OneToMany
    private List<Order> orders;

    @Builder
    public User(String username, String password, String email, String firstName, String lastName, Gender gender, LocalDateTime createDate, LocalDateTime modificationDate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.createDate = createDate;
        this.modificationDate = modificationDate;
        this.orders = new ArrayList<>();
    }
}
