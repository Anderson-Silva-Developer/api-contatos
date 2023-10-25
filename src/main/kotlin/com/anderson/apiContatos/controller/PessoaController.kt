package com.anderson.apiContatos.controller

import com.anderson.apiContatos.dto.PessoaReqDto
import com.anderson.apiContatos.dto.PessoaRespDto
import com.anderson.apiContatos.service.PessoaService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/pessoas")
class PessoaController(private val pessoaService: PessoaService) {
    @PostMapping
    fun salvaConta(@RequestBody pessoa: PessoaReqDto):ResponseEntity<PessoaRespDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvarPessoa(pessoa))
    }

    @GetMapping
    fun buscarTodasContas(): ResponseEntity<List<PessoaRespDto>>  {
        return ResponseEntity.status(HttpStatus.OK).body( pessoaService.buscarTodasPessoas())
    }

    @GetMapping("/{id}")
    fun buscarConta(@PathVariable id: Long): ResponseEntity<PessoaRespDto> {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPessoaPeloId(id))
    }
    @PutMapping("/{id}")
    fun ataualizarConta(@PathVariable id: Long,@RequestBody pessoa:PessoaReqDto): ResponseEntity<Void> {
        pessoaService.atualizarPessoa(pessoa,id)
        return ResponseEntity.status(HttpStatus.OK).build()
    }

}


