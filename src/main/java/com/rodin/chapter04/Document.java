package com.rodin.chapter04;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class Document {

    private final Map<String, String> attributes;

}
