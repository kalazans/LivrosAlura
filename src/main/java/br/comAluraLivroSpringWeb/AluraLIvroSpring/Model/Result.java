package br.comAluraLivroSpringWeb.AluraLIvroSpring.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record Result(@JsonAlias("data") List<DadosLivro> lista) {
}
