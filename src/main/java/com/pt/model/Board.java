package com.pt.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;
    private Date createDate;
    private int view;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users user;
/*

    @OneToMany
    private List<FileDTO> files = new ArrayList<FileDTO>();
*/


}
