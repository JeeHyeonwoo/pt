package com.pt.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "file")
@Data
public class FileDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
/*
    @ManyToOne
    @JoinColumn(name = "boardId")
    private Board board;*/
}
