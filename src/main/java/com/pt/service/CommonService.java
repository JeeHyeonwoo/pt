package com.pt.service;

import com.pt.model.Paging;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class CommonService<T> {

    public Paging pageRange(Page<T> pageData) {
        int start = ((int) pageData.getNumber() / 10) * 10 + 1;
        int end = pageData.getTotalPages() + 1 >= 10 ? start + 9 : pageData.getTotalPages() + 1;
        Paging paging = new Paging(start, end);

        return paging;
    }
}
