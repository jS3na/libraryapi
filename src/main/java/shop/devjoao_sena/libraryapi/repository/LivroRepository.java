package shop.devjoao_sena.libraryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import shop.devjoao_sena.libraryapi.model.Autor;
import shop.devjoao_sena.libraryapi.model.Livro;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

/**
 * @see LivroRepositoryTest
 */
public interface LivroRepository extends JpaRepository<Livro, UUID> {

    List<Livro> findByAutor(Autor autor);

    List<Livro> findByTituloContaining(String titulo);
    List<Livro> findByTituloAndPreco(String titulo, BigDecimal preco);

    // JPQL -> é como se fosse um sql só que do spring boot
    @Query(" select l from Livro as l order by l.titulo ")
    List<Livro> listarTodosOrdenandoPeloTitulo();

    List<Livro> findByOrderByTitulo();

}
