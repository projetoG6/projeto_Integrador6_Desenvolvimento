package com.grupo6.buntuconectapp.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springBlogpessoalOpenAPI() {
        return new OpenAPI()


                .info(new Info()
                                .title("Buntuconecta")
                                .description("Rede Social - BuntuConecta Mercado Livre")
                                .version("1.0")
                                .license(new License()
                                .name("Mercado Livre")
                                .url("https://github.com/projetoG6"))
                                .contact(new Contact().name("Grupo6")
                                .email("buntuconecta.meli@gmail.com").url("https://github.com/projetoG6")))
                                .externalDocs(new ExternalDocumentation()
                                .description("GitHub")
                                .url("https://github.com/projetoG6"));
    }

    @Bean
    public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser(){


        return openApi -> {
            openApi.getPaths().values().forEach(p->p.readOperations().forEach(operation -> {


                ApiResponses apiResponses = operation.getResponses();


                apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
                apiResponses.addApiResponse("201", createApiResponse("Objeto Persistido!"));
                apiResponses.addApiResponse("204", createApiResponse("Objeto Excluido !"));
                apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!"));
                apiResponses.addApiResponse("401", createApiResponse("Acesso nao autorizado!"));
                apiResponses.addApiResponse("404", createApiResponse("Objeto nao encontrado!"));
                apiResponses.addApiResponse("500", createApiResponse("Erro na aplicação!"));


            }));
        };


    }
    private ApiResponse createApiResponse(String message) {

        return new ApiResponse().description(message);
    }
}