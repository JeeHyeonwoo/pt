package com.pt.model;

import lombok.Data;

@Data
public abstract class Search {
    protected Paging paging;
    protected String condition;
}
