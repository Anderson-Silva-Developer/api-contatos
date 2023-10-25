package com.anderson.apiContatos.dto

import com.fasterxml.jackson.annotation.JsonInclude

class PessoaRespDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var id: Long=0
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var nome: String=""
    @JsonInclude(JsonInclude.Include.NON_NULL)
    var telefone:String=""
    constructor() { }
}

