package com.pt.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "file")
@Data
public class FileDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private String filename;

    @ManyToOne
    @JoinColumn(name= "board_id")
    private Board board;
}
