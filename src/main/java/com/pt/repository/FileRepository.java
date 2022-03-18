package com.pt.repository;

import com.pt.model.FileDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileDTO, Long> {
    Optional<FileDTO> findByBoardId(Long id);
}
