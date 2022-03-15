package com.pt.service;

import com.pt.model.Board;
import com.pt.repository.BoardRepository;
import com.pt.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final FileRepository fileRepository;

    public void save(Board board){}
}
