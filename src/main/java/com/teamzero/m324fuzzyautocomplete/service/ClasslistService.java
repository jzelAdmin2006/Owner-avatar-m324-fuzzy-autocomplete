package com.teamzero.m324fuzzyautocomplete.service;

import static com.teamzero.m324fuzzyautocomplete.model.Student.fromJsonArray;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.io.FileUtils.readFileToString;

import com.teamzero.m324fuzzyautocomplete.model.Student;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ClasslistService {


  public List<Student> readClasslist() throws IOException {
    return fromJsonArray(readFileToString(new File("class.json"), UTF_8));
  }
}
