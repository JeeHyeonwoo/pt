package com.pt.service;

import com.pt.model.FileDTO;
import com.pt.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


@Service
@RequiredArgsConstructor
public class FileService {

    /**
     * 확장자 검출
     */
    private final FileRepository fileRepository;

    public String getExtension(String filename) {
        return filename.substring(filename.lastIndexOf(".") + 1);
    }

    /**
     * permit: 허용하는 확장자
     */
    public FileDTO fileValidation(MultipartFile multipartFile, String... permit) throws IOException, IllegalStateException {
        boolean validation = Arrays.asList(permit).contains(getExtension(multipartFile.getOriginalFilename()));

        if (validation) {
            FileDTO file = new FileDTO();
            file.setPath("C:\\file\\");
            file.setFilename(UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename());
            return file;
        }
        return null;
    }


}
