package com.teamzero.m324fuzzyautocomplete.service;

import static com.teamzero.m324fuzzyautocomplete.model.Student.fromJsonArray;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.io.FileUtils.readFileToString;

import com.teamzero.m324fuzzyautocomplete.model.Student;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ClasslistService {

  public File convertToFile(MultipartFile multipartFile) throws IOException {
    File tempFile = File.createTempFile("upload-", multipartFile.getOriginalFilename());
    tempFile.deleteOnExit();
    multipartFile.transferTo(tempFile);
    return tempFile;
  }

  public List<Student> readClasslist(File file) throws IOException {
    return fromJsonArray(readFileToString(file, UTF_8));
  }
  public List<Student> readClasslist() throws IOException {
    return fromJsonArray(readFileToString(new File("class.json"), UTF_8));
  }
}
