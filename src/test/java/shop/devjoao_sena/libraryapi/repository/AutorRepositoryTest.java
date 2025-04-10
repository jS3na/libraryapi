package shop.devjoao_sena.libraryapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import shop.devjoao_sena.libraryapi.model.Autor;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Test
    public void salvarTeste(){
        Autor autor = new Autor();
        autor.setNome("joao");
        autor.setNacionalidade("brasileiro");
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

}
