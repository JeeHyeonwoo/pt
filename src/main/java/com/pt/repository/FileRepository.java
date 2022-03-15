package com.pt.repository;

import com.pt.model.FileDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<FileDTO, Long> {
}
