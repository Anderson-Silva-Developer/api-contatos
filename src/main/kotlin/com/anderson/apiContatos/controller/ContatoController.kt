package com.anderson.apiContatos.controller

import com.anderson.apiContatos.dto.ContatoReqDto
import com.anderson.apiContatos.dto.ContatoRespDto
import com.anderson.apiContatos.service.ContatoService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/contatos")
class ContatoController (private  val contatoService: ContatoService){
    @PostMapping("pessoa/{pessoaId}")
    fun salvaContato(@RequestBody @Valid contatoReqDto: ContatoReqDto, @PathVariable("pessoaId") pessoaId:Long):ResponseEntity<ContatoRespDto>{
       return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.salvarContato(contatoReqDto,pessoaId))
    }
    @GetMapping("/pessoa/{pessoaId}")
    fun buscarTodosContatos(@PathVariable("pessoaId") pessoaId:Long):ResponseEntity<List<ContatoRespDto>>{
        return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.buscarTodosContatos(pessoaId))
    }


}
