package br.com.pedroanhezini.api.controller;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ResponseError {
    LocalDateTime timestamp;
    String message;
    String key;

}
