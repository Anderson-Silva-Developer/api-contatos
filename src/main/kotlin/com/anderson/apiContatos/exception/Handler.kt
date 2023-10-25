package com.anderson.apiContatos.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class Handler {
    @ExceptionHandler(NotFound::class)
    fun handleNotFoundException(exception: NotFound): ResponseEntity<DetalhesErro> {
        var erro = DetalhesErro();
        erro.titulo = "O objeto não encontrado!"
        erro.status = 404L
        erro.menssagemDesenvolvedor = exception.message
        erro.timestamp = System.currentTimeMillis()
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
    }
    @ExceptionHandler(ConflitoException::class)
    fun handleNotFoundException(exception: ConflitoException): ResponseEntity<DetalhesErro> {
        var erro = DetalhesErro();
        erro.titulo = "Conflito!"
        erro.status = 409L
        erro.menssagemDesenvolvedor = exception.message
        erro.timestamp = System.currentTimeMillis()
        return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
    }
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleMethodArgumentNotValidException(exception: MethodArgumentNotValidException): ResponseEntity<DetalhesErro> {
        var erro = DetalhesErro();
        erro.titulo = "Argumento inválido !!"
        erro.status = 400L
        var msm:String =exception.fieldErrors.map{it.defaultMessage}.toString()
        erro.menssagemDesenvolvedor = msm.toString()
        erro.timestamp = System.currentTimeMillis()
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

}