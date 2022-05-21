package com.example.springgraphql.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(String name) {
        this.name = name;
    }

    @PrePersist
    public void roleNameToUpperCase() {
        if (!StringUtils.isAllUpperCase(name)) {
            name = name.toUpperCase();
        }
    }
}
