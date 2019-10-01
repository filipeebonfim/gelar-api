package com.gelarapi.controller;

import com.gelarapi.model.Administrador;
import com.gelarapi.model.Escola;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @PostMapping("/novoadm")
    public ResponseEntity<JSONObject> addAdministrador(@RequestBody Administrador adm) {
        JSONObject json = new JSONObject();
        boolean ok = true;
        StringBuilder retMsg = new StringBuilder();


    }
}
