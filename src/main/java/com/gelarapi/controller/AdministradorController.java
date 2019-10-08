package com.gelarapi.controller;

import com.gelarapi.model.Administrador;
import com.gelarapi.model.Escola;
import com.gelarapi.model.Usuario;
import com.gelarapi.repositories.AdministradorDAO;
import com.gelarapi.repositories.UsuarioDAO;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private AdministradorDAO admDAO;

    @PostMapping("/novoadm")
    public ResponseEntity<JSONObject> addAdministrador(@RequestBody Administrador adm) {
        JSONObject json = new JSONObject();
        boolean ok = true;
        StringBuilder retMsg = new StringBuilder();
        Usuario user = new Usuario();
        if(adm.getLogin() != null && adm.getLogin() != "")
            user = usuarioDAO.findByLogin(adm.getLogin());

        if(user != null) {
            retMsg.append("login já cadastrado");
            ok = false;
        }
        else{
            admDAO.save(adm);
            retMsg.append("Administrador criado com sucesso");
        }

        json.put("statusMsg", retMsg.toString());

        return new ResponseEntity<>(json, ok == true ? HttpStatus.CREATED : HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getEscolas(){
        System.out.println("Procurando escolas");
        return new ResponseEntity<>(admDAO.findAll(), HttpStatus.OK);
    }
}
