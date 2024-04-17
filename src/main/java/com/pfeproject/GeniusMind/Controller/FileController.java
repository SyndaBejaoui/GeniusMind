package com.pfeproject.GeniusMind.Controller;

import com.pfeproject.GeniusMind.Entity.CoursEntity;
import com.pfeproject.GeniusMind.Repository.CoursRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/auth/File")
@AllArgsConstructor
@Slf4j
public class FileController {

    @Autowired
    private CoursRepository coursRepository;


    @PostMapping("/Add")
    public ResponseEntity<CoursEntity> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            log.info(file.getBytes().toString());

            CoursEntity entity = new CoursEntity();
            entity.setFileName(file.getOriginalFilename());
            entity.setFileContent(file.getBytes());
            CoursEntity savedEntity = coursRepository.save(entity);
            return ResponseEntity.ok(savedEntity);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/GETAll")
    public List<CoursEntity> getAllCourses() {
        return coursRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable Long id) {
        Optional<CoursEntity> optionalEntity = coursRepository.findById(id);
        if (optionalEntity.isPresent()) {
            CoursEntity entity = optionalEntity.get();
            String encodedFileName = UriUtils.encode(entity.getFileName(), StandardCharsets.UTF_8);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDisposition(ContentDisposition.builder("attachment").filename(encodedFileName).build());
            return ResponseEntity.ok().headers(headers).body(entity.getFileContent());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Long id) {
        try {
            coursRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }


}


