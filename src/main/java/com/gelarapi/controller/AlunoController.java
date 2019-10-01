package com.gelarapi.controller;

import com.gelarapi.model.Aluno;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @PostMapping("/novoaluno")
    public ResponseEntity<JSONObject> addAdministrador(@RequestBody Aluno aluno) {
        JSONObject json = new JSONObject();
        boolean ok = true;
        StringBuilder retMsg = new StringBuilder();

    }
}
