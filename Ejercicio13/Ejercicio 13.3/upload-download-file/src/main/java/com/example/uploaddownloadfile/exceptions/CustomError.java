package com.example.uploaddownloadfile.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class CustomError {
    public String message;
    public int httpStatus;
    public Date timeStamp;
}
