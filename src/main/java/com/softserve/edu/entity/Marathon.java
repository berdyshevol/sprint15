package com.softserve.edu.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "marathons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Marathon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    String name;

    @ManyToMany
    @JoinTable(
            name = "marathons_users",
            joinColumns = {@JoinColumn(name = "marathons_id")},
            inverseJoinColumns = {@JoinColumn(name = "users_id")}
    )
    private List<User> users;

}
