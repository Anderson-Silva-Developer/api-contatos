package com.anderson.apiContatos.service

import com.anderson.apiContatos.dto.PessoaReqDto
import com.anderson.apiContatos.dto.PessoaRespDto
import com.anderson.apiContatos.exception.ConflitoException
import com.anderson.apiContatos.exception.NotFound
import com.anderson.apiContatos.model.Pessoa
import com.anderson.apiContatos.repository.PessoaRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PessoaService(private val pessoaRepository: PessoaRepository, private val modelmapper:ModelMapper) {
    @Transactional
    fun salvarPessoa(pessoaReqDto: PessoaReqDto): PessoaRespDto {
        validarCadastroPessoa(pessoaReqDto)
        var pessoa=converterDtoParaPessoa(pessoaReqDto)
        return converterPessoaParaDto(pessoaRepository.save(pessoa))
    }

    fun buscarTodasPessoas(): List<PessoaRespDto>{
      return  pessoaRepository
            .findAll()
            .map {converterPessoaParaDto(it)}.toList()
    }

    fun buscarPessoaPeloId(id: Long): PessoaRespDto {
        return converterPessoaParaDto(buscarPessoa(id))
    }
    fun buscarPessoa(id: Long): Pessoa {
        val pessoa= pessoaRepository.findById(id)
            .orElseThrow {NotFound("Pessoa não encontrada!") }
        return pessoa
    }
    @Transactional
    fun atualizarPessoa(pessoaAtualizada:PessoaReqDto, id:Long){
        var pessoa=buscarPessoa(id)
        pessoa.nome=pessoaAtualizada.nome?:pessoa.nome
        pessoa.telefone=pessoaAtualizada.telefone?:pessoa.telefone
        pessoaRepository.save(pessoa)
    }
    fun converterPessoaParaDto(pessoa: Pessoa): PessoaRespDto {
        var contaRespDto= modelmapper.map(pessoa, PessoaRespDto::class.java)
        return contaRespDto
    }
    fun converterDtoParaPessoa(pessoa: PessoaReqDto): Pessoa {
        var conta= modelmapper.map(pessoa, Pessoa::class.java)
        return conta
    }
    fun validarCadastroPessoa(pessoaReqDto: PessoaReqDto){
        val pessoa=pessoaRepository.findByTelefone(pessoaReqDto.telefone)
        if(pessoa!=null){
            throw ConflitoException("Este telefone já está associado a outra pessoa !")
        }
    }

}

