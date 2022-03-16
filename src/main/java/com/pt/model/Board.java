package com.pt.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String contents;

    @CreatedDate
    @Column(updatable = false)
    private Date createDate;
    private int view;

    @ManyToOne
    @JoinColumn(name = "userid")
    private Users user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileDTO> files = new ArrayList<>();

    public void addFile(FileDTO fileDTO) {
        this.files.add(fileDTO);
    }

}
