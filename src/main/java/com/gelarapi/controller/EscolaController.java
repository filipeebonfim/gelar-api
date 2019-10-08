package com.gelarapi.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gelarapi.model.Administrador;
import com.gelarapi.model.Escola;
import com.gelarapi.repositories.AdministradorDAO;
import com.gelarapi.repositories.EscolaDAO;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/escola")
public class EscolaController {

    @Autowired
    private EscolaDAO escolaDAO;
    @Autowired
    private AdministradorDAO admDAO;

    @PostMapping("/novaescola")
    public ResponseEntity<JSONObject> addEscola(@RequestBody Escola escola){
        JSONObject json = new JSONObject();
        boolean ok = true;
        StringBuilder retMsg = new StringBuilder();

        String nome = escola.getNome();
        if(nome == null || nome.equals("")){
            retMsg.append("Nome invalido ");
        }

        if(escola.getEndereco() == null){
            retMsg.append("Endereço obrigatorio");
            ok = false;
        }

        if(escola.getDiretor() == null){
            retMsg.append("Diretor obrigatorio");
            ok = false;
        }else{
            Optional<Administrador> adm = admDAO.findById(escola.getDiretor().getId());

            if(adm.isPresent())
                escola.setDiretor(adm.get());
            else {
                retMsg.append("Diretor não encontrado");
                ok = false;
            }
        }

        if(ok){
            escolaDAO.save(escola);
            retMsg.append("Escola inserida");
        }

        json.put("statusMsg", retMsg.toString());
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getEscolas(){
        System.out.println("Procurando escolas");
        return new ResponseEntity<>(escolaDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Escola> getEscolaById(@PathVariable("id") Long id){
        System.out.println("Procurando escola id: " + id.toString());
        Optional<Escola> escola = escolaDAO.findById(id);

        if(escola.isPresent())
            return new ResponseEntity<>(escola.get(), HttpStatus.OK);

        return new ResponseEntity<>(new Escola(), HttpStatus.OK);
    }
}
