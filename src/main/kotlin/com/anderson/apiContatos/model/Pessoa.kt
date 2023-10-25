package com.anderson.apiContatos.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity(name = "pessoa")
class Pessoa(
    @Id @GeneratedValue
    var id: Long? = null,
    var nome: String,
    var telefone:String
) {

}
