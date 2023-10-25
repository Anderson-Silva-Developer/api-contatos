package com.anderson.apiContatos.dto

import jakarta.validation.constraints.NotNull

class PessoaReqDto {
    @NotNull(message = "O nome não pode ser vazio ou nulo!")
    var nome: String?=null
    @NotNull(message = "O telefone não pode ser vazio ou nulo!")
    var telefone: String?=null
    constructor() { }
}

