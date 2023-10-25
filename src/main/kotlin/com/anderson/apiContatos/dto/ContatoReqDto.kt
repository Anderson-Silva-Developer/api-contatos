package com.anderson.apiContatos.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotNull

class ContatoReqDto {
    @NotNull(message = "O nome não pode ser vazio ou nulo!")
    var nome: String? = null

    @NotNull(message = "O telefone não pode ser vazio ou nulo!")
    var telefone: String? = null

    @Email(message = "E-mail inválido")
    @NotNull(message = "O E-mail não pode ser vazio ou nulo!")
    var email: String? = null

    constructor() {}
}