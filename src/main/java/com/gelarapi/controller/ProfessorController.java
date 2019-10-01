package com.gelarapi.controller;

import com.gelarapi.model.Professor;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @PostMapping("/novoprofessor")
    public ResponseEntity<JSONObject> addAdministrador(@RequestBody Professor professor) {
        JSONObject json = new JSONObject();
        boolean ok = true;
        StringBuilder retMsg = new StringBuilder();
    }
}
