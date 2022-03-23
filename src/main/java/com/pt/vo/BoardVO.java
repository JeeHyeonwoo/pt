package com.pt.vo;

import com.pt.model.Paging;
import lombok.Data;

import java.util.Date;

@Data
public class BoardVO extends Paging {
    private Long id;
    private String title;
    private String contents;

    private Date createDate;
    private int view;


}
