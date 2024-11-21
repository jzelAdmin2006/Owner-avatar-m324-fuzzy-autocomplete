package com.teamzero.m324fuzzyautocomplete.webservice.adapter.rest;

import static java.util.Comparator.comparingInt;

import com.teamzero.m324fuzzyautocomplete.model.Student;
import com.teamzero.m324fuzzyautocomplete.service.ClasslistService;
import com.teamzero.m324fuzzyautocomplete.service.LevenshteinService;

import java.io.File;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class SearchController {

  private final LevenshteinService levenshteinService;
  private final ClasslistService classlistService;

  @Nullable
  private File uploadedFile;

  /**
   * Endpoint to handle file upload for student data.
   *
   * @param file the uploaded file containing student data in JSON format
   * @return a list of parsed Student objects
   * @throws IOException if file reading fails
   */
  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
    if (file.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }

    uploadedFile = classlistService.convertToFile(file);
    return ResponseEntity.ok("File uploaded");
  }

  @GetMapping("/search/{input}")
  public ResponseEntity<List<Student>> search(final @PathVariable String input) throws IOException {
    final String lowerInput = input.toLowerCase();
    List<Student> students;
    if(uploadedFile == null){
      students = classlistService.readClasslist();
    }else{
      students = classlistService.readClasslist(uploadedFile);
    }
    return ResponseEntity.ok(
            students.stream()
            .map(s -> new SimpleEntry<>(s, levenshteinService.calcDistance(lowerInput, s.name().toLowerCase())))
            .filter(e -> e.getValue() <= 2)
            .sorted(comparingInt(SimpleEntry::getValue))
            .map(SimpleEntry::getKey)
            .toList()
    );
  }
}
