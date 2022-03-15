package com.pt.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Long id;
    private String name;

    /** Fetch :JPA가 하나의 Entity를 조회할 때 연관관계에 있는 객체들을 어떻게 가져올 것이냐를 나타내는 설정값
     *
     *      Type
     *  EAGER : Join을 통해 한번에 모든 쿼리를 가져온다.
     *  
     * **/

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER)
    private List<Users> users;

    @Override
    public String getAuthority() {
        return name;
    }

    public void setAuthority(String name) {
        this.name = name;
    }

}
