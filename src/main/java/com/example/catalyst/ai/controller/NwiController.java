package com.example.catalyst.ai.controller;

import com.example.catalyst.ai.dto.NwiResponse;
import com.example.catalyst.ai.service.NwiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portal/api/nwi")
@RequiredArgsConstructor
public class NwiController {
    private final NwiService service;
    @GetMapping("getText")
    public ResponseEntity<NwiResponse> getText() {
        return new ResponseEntity<>(new NwiResponse("Hello World!"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NwiResponse> getNwi(@PathVariable Long id) {
        return new ResponseEntity<>(service.getNwi(id), HttpStatus.OK);
    }

    @PostMapping("/{name}")
    public ResponseEntity<Long> saveNwi(@PathVariable String name) {
        return new ResponseEntity<>(service.saveNwi(name), HttpStatus.OK);
    }
}
