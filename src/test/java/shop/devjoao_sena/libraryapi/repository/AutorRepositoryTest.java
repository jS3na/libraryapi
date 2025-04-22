package shop.devjoao_sena.libraryapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import shop.devjoao_sena.libraryapi.model.Autor;
import shop.devjoao_sena.libraryapi.model.GeneroLivro;
import shop.devjoao_sena.libraryapi.model.Livro;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTeste(){
        Autor autor = new Autor();
        autor.setNome("maria");
        autor.setNacionalidade("argentina");
        autor.setDataNascimento(LocalDate.of(1950, 1, 12));

        var autorSalvo = repository.save(autor);
        System.out.println("Autor Salvo: " + autorSalvo);
    }

    @Test
    public void atualizarTeste(){
        var id = UUID.fromString("ac78bfa2-0a10-4dbd-b403-f3e3afbe2ea0");
        Optional<Autor> possivelAutor = repository.findById(id);

        if(possivelAutor.isPresent()){

            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Autor encontrado: " + autorEncontrado);

            autorEncontrado.setNome("joao atualizado");
            repository.save(autorEncontrado);
        }
    }

    @Test
    public void listarTeste(){
        List<Autor> autores = repository.findAll();
        autores.forEach(System.out::println);
    }

    @Test
    public void countTeste(){
        long count = repository.count();
        System.out.println("Quantidade de autores encontrados: " + count);
    }

    @Test
    public void deletarTeste(){
        var id = UUID.fromString("9edfeabe-2b85-4537-b9be-c29faccf5ad3");
        Optional<Autor> possivelAutor = repository.findById(id);

        if(possivelAutor.isPresent()){

            Autor autorEncontrado = possivelAutor.get();
            repository.delete(autorEncontrado);

            System.out.println("Autor deletado");
        }
    }

    @Test
    void salvarAutorComLivrosTeste(){
        Autor autor = new Autor();
        autor.setNome("ze ruela");
        autor.setNacionalidade("uruguaio");
        autor.setDataNascimento(LocalDate.of(2005, 5, 26));

        Livro livro = new Livro();
        livro.setIsbn("1231231-1234");
        livro.setPreco(BigDecimal.valueOf(200));
        livro.setGenero(GeneroLivro.MISTERIO);
        livro.setTitulo("A ilha");
        livro.setDataPublicacao(LocalDate.of(2011, 2, 11));
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setIsbn("12312-1234");
        livro2.setPreco(BigDecimal.valueOf(300));
        livro2.setGenero(GeneroLivro.FANTASIA);
        livro2.setTitulo("valha sla");
        livro2.setDataPublicacao(LocalDate.of(2013, 4, 22));
        livro2.setAutor(autor);

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);
    }

    @Test
    void mostrarLivrosAutor(){
        var id = UUID.fromString("4d416832-210f-42b7-b706-bab41062563e");
        Optional<Autor> autor = repository.findById(id);

        if(autor.isPresent()){
            Autor autorEncontrado = autor.get();

            List<Livro> livros = livroRepository.findByAutor(autorEncontrado);

            livros.forEach(System.out::println);

        }
    }

}
