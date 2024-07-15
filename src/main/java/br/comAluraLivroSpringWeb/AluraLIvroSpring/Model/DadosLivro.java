package br.comAluraLivroSpringWeb.AluraLIvroSpring.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLivro(@JsonAlias("id") Long id,
                         @JsonAlias("title") String title,
                         @JsonAlias("year") int ano,
                         @JsonAlias("pages") int page) {
}
