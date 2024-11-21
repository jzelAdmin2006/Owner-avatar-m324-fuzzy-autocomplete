package com.teamzero.m324fuzzyautocomplete.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public record Student(String name, int age) {

  private static final Gson GSON = new Gson();
  private static final Type CLASS_LIST = new TypeToken<List<Student>>() {
  }.getType();

  public static List<Student> fromJsonArray(final String studentArray) {
    return GSON.fromJson(studentArray, CLASS_LIST);
  }
}
