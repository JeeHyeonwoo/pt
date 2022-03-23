package com.pt.model.dto;

import com.pt.domain.Meta;
import com.pt.model.Search;
import lombok.Data;

@Data
public class BoardSearch extends Search {
    /*protected SearchType searchType;

    public enum SearchType implements Meta {
        TITLE("제목"),
        WRITER("작성자"),
        CONTENT("내용"),
        PERIOD("기간"),;

        private String desc;

        SearchType(String desc){ this.desc = desc;}

        @Override
        public String getDescription() {return null;}
    }*/
}
