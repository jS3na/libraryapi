package shop.devjoao_sena.libraryapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import shop.devjoao_sena.libraryapi.model.Autor;
import shop.devjoao_sena.libraryapi.model.GeneroLivro;
import shop.devjoao_sena.libraryapi.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarTeste(){

        Livro livro = new Livro();
        livro.setIsbn("90312-12312");
        livro.setPreco(BigDecimal.valueOf(100));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Alien");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 2));

        Autor autor = autorRepository.findById(UUID.fromString("ac78bfa2-0a10-4dbd-b403-f3e3afbe2ea0")).orElse(null);

        livro.setAutor(autor);

        repository.save(livro);

    }

    @Test
    @Transactional
    void buscarLivroTeste(){
        UUID id = UUID.fromString("b3bec921-0977-42d1-af8a-c340c1ea2473");
        Livro livro = repository.findById(id).orElse(null);

        System.out.println("Livro: " + livro.getTitulo());
        System.out.println("Autor: " + livro.getAutor().getNome());
    }

    @Test
    void buscarLivro(){
//        List<Livro> livros = repository.findByTituloContaining("Alien");
//        List<Livro> livros = repository.findByTituloAndPreco("Alien", BigDecimal.valueOf(100));
//        List<Livro> livros = repository.listarTodosOrdenandoPeloTitulo();
        List<Livro> livros = repository.findByOrderByTitulo();

        livros.forEach(System.out::println);
    }


}