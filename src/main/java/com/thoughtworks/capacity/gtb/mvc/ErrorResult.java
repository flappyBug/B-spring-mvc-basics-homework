package com.thoughtworks.capacity.gtb.mvc;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResult {
    int code;
    String message;
}
