package br.comAluraLivroSpringWeb.AluraLIvroSpring.Service;

import br.comAluraLivroSpringWeb.AluraLIvroSpring.Model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro,Long> {
    Optional<Livro> findByTitleContainingIgnoreCase(String livro);
    Optional<Livro> findByAnoEquals(int ano);
    List<Livro> findByPagesGreaterThan(int pages);
    List<Livro> findByPagesLessThan(int pages);

}
