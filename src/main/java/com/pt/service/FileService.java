package com.pt.service;

import com.pt.model.FileDTO;
import com.pt.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class FileService {

    private final FileRepository fileRepository;
    public String getExtension(String filename) {
        return filename.substring(filename.lastIndexOf(".") + 1);
    }

    /**
     * permit: 허용하는 확장자
     * */
    /*public Optional<List<FileDTO>> fileSave(MultipartFile[] multipartFiles, String... permit) throws IOException, IllegalStateException {
        List<FileDTO> files = new ArrayList<FileDTO>();

        for(MultipartFile multipartFile : multipartFiles){
            if (Arrays.asList(permit).contains(getExtension(multipartFile.getName()))){
                File newFile = new File("C:\\file\\" + UUID.randomUUID().toString() + "_" + multipartFile.getName());
                multipartFile.transferTo(newFile);
                files.add(FileDTO.builder().path(newFile.getPath()).build());
            }
        }
        return Optional.ofNullable(files);
    }*/
}
