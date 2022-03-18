package com.pt.controller;

import com.pt.model.Board;
import com.pt.model.FileDTO;
import com.pt.repository.BoardRepository;
import com.pt.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageController {

    private final BoardRepository boardRepository;
    private final FileRepository fileRepository;

    @GetMapping(value = "/download")
    public ResponseEntity<Resource> download(@RequestParam(value= "id", required = false) Long id) throws IOException {
        HttpHeaders header = new HttpHeaders();
        if(id != null) {
            FileDTO file = fileRepository.findByBoardId(id).orElse(null);
            try{
                String path = file.getPath() + file.getFilename();
                Resource resource = new FileSystemResource(path);
                Path filePath = Paths.get(path);
                header.add("Content-Type", Files.probeContentType(filePath));
                return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);
            }catch (Exception e) {

            }
        }

        Resource resource = new FileSystemResource("C:\\Users\\user2\\Documents\\카카오톡 받은 파일\\KakaoTalk_20220120_172558217.jpg");
        Path filePath = Paths.get("C:\\Users\\user2\\Documents\\카카오톡 받은 파일\\KakaoTalk_20220120_172558217.jpg");
        header.add("Content-Type", Files.probeContentType(filePath));
        return new ResponseEntity<Resource>(resource, header, HttpStatus.NOT_FOUND);
    }

}
