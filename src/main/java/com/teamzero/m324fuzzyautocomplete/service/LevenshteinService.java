package com.teamzero.m324fuzzyautocomplete.service;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.concat;

import java.util.stream.IntStream;
import org.springframework.stereotype.Service;

@Service
public class LevenshteinService {

  public int calcDistance(final String x, final String y) {
    final int[][] matrix = new int[x.length() + 1][y.length() + 1];

    for (int i = 0; i <= x.length(); i++) {
      for (int j = 0; j <= y.length(); j++) {
        if (i == 0) {
          matrix[i][j] = j;
        } else if (j == 0) {
          matrix[i][j] = i;
        } else {
          matrix[i][j] = min(
              matrix[i - 1][j - 1] + (x.charAt(i - 1) == y.charAt(j - 1) ? 0 : 1),
              matrix[i - 1][j] + 1,
              matrix[i][j - 1] + 1
          );
        }
      }
    }

    return matrix[x.length()][y.length()];
  }

  private int min(int number, int... numbers) {
    return concat(IntStream.of(number), stream(numbers)).min().orElse(number);
  }
}
