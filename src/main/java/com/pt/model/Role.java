package com.pt.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER)
    private Set<Users> users;

    @Override
    public String getAuthority() {
        return name;
    }

    public void setAuthority(String name) {
        this.name = name;
    }

}
