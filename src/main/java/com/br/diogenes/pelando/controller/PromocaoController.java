package com.br.diogenes.pelando.controller;

import com.br.diogenes.pelando.model.Promocao;
import com.br.diogenes.pelando.repository.PromocaoRepository;
import com.br.diogenes.pelando.resources.HtmlParse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping({"/promocao"})
public class PromocaoController {


    @Autowired
    private PromocaoRepository repository;



        @GetMapping
        public List<Promocao> findAll(){
            return repository.findAll();
        }

        @PostMapping
        public ResponseEntity<Promocao> create(String url){
            HtmlParse parser = new HtmlParse();
//            Promocao newPromocao = repository.existsByUrl(url);
//
////            if (!Objects.isNull(newPromocao)) {
////                if(!newPromocao.getLastAdd().plus(60, ChronoUnit.MINUTES).isAfter(Instant.now())){
////                    return new ResponseEntity("promoção adicionada a menos de 1 hora", HttpStatus.BAD_REQUEST);
////                }
////            }
            repository.save(parser.promocao(url));
            return ResponseEntity.ok().body(repository.save(parser.promocao(url)));
        }
}
