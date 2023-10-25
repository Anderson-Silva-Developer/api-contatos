package com.anderson.apiContatos.service

import com.anderson.apiContatos.dto.ContatoReqDto
import com.anderson.apiContatos.dto.ContatoRespDto
import com.anderson.apiContatos.model.Contato
import com.anderson.apiContatos.repository.ContatoRepository
import org.modelmapper.ModelMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ContatoService(private val contatoRepository: ContatoRepository, private  val pessoaService: PessoaService, private val modelMapper: ModelMapper) {

    @Transactional
    fun salvarContato(contatoReqDto: ContatoReqDto, pessoaId:Long): ContatoRespDto {
        var contato=converterDtoParaContato(contatoReqDto)
        contato.pessoa= pessoaService.buscarPessoa(pessoaId)
        return converterContatoParaDto(contatoRepository.save(contato))
    }
    fun buscarTodosContatos(pessoaId: Long): List<ContatoRespDto>? {
     return  contatoRepository.findByPessoaId(pessoaId)
         .map {converterContatoParaDto(it)}.toList()
    }
    fun converterContatoParaDto(contato: Contato): ContatoRespDto {
        var contatoRespDto= modelMapper.map(contato, ContatoRespDto::class.java)
        return contatoRespDto
    }
    fun converterDtoParaContato(contatoReqDto: ContatoReqDto): Contato {
        var contato= modelMapper.map(contatoReqDto, Contato::class.java)
        return contato
    }


}