package com.anderson.apiContatos.repository

import com.anderson.apiContatos.model.Contato
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ContatoRepository:JpaRepository<Contato,Long> {
    fun findByPessoaId(pessoaId: Long):List<Contato>
}