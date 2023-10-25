package com.anderson.apiContatos.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne

@Entity(name = "contato")
class Contato(
    @Id @GeneratedValue
    var id: Long? = null,
    var nome: String,
    var telefone:String,
    var email:String?=null,
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    var pessoa: Pessoa
)
