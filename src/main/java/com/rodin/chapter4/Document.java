package com.rodin.chapter4;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

public record Document(Map<String, String> attributes) {

}
