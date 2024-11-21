package com.teamzero.m324fuzzyautocomplete.webservice.adapter.rest;

import static java.util.Comparator.comparingInt;

import com.teamzero.m324fuzzyautocomplete.model.Student;
import com.teamzero.m324fuzzyautocomplete.service.ClasslistService;
import com.teamzero.m324fuzzyautocomplete.service.LevenshteinService;
import java.io.IOException;
import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SearchController {

  private final LevenshteinService levenshteinService;
  private final ClasslistService classlistService;

  @GetMapping("/search/{input}")
  public ResponseEntity<List<Student>> search(final @PathVariable String input) throws IOException {
    final String lowerInput = input.toLowerCase();
    return ResponseEntity.ok(
        classlistService.readClasslist().stream()
            .map(s -> new SimpleEntry<>(s, levenshteinService.calcDistance(lowerInput, s.name().toLowerCase())))
            .filter(e -> e.getValue() <= 2)
            .sorted(comparingInt(SimpleEntry::getValue))
            .map(SimpleEntry::getKey)
            .toList()
    );
  }
}
