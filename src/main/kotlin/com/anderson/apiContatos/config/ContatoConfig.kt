package com.anderson.apiContatos.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ContatoConfig {
    @Bean
    fun modelmapper():ModelMapper{
        var modelMapper=ModelMapper()
        return modelMapper
    }
}