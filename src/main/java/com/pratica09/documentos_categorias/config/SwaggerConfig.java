package com.pratica09.documentos_categorias.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "API Documentos e Categorias",
        version = "1.0",
        description = "CRUD de Documentos e Categorias com Spring Boot",
        contact = @Contact(
            name = "Seu Nome",
            email = "seuemail@dominio.com",
            url = "https://github.com/seu-usuario"
        ),
        license = @License(
            name = "Apache 2.0",
            url = "http://springdoc.org"
        )
    )
)
public class SwaggerConfig {
    // Não precisa de código adicional, só as anotações
}
