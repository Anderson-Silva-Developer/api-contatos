package com.anderson.apiContatos.repository

import com.anderson.apiContatos.model.Pessoa
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PessoaRepository:JpaRepository<Pessoa,Long> {
    fun findByTelefone(telefone:String?):Pessoa?
}