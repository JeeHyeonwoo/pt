package com.pt.service;

import com.pt.model.Board;
import com.pt.model.Paging;
import com.pt.repository.BoardRepository;
import com.pt.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final FileRepository fileRepository;

    public Page<Board> list(Pageable pageable) {

        Page<Board> page = boardRepository.findAll(pageable);
        int start = ((int) page.getNumber() / 10) * 10 + 1 ;
        int end = page.getTotalPages() + 1 >= 10 ? start + 9 : page.getTotalPages() + 1;

        Paging pageRange = new Paging(start, end);

        return page;
    }

    public void save(Board board){}
}
