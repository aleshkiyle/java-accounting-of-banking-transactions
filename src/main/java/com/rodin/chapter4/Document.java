package com.rodin.chapter4;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@AllArgsConstructor
@Getter
public class Document {

    private final Map<String, String> attributes;

}
