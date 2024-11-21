package com.teamzero.m324fuzzyautocomplete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.teamzero.m324fuzzyautocomplete.config")
public class M324FuzzyAutocompleteApplication {

  public static void main(String[] args) {
    SpringApplication.run(M324FuzzyAutocompleteApplication.class, args);
  }

}
