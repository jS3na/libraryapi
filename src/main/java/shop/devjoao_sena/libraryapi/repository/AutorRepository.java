package shop.devjoao_sena.libraryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.devjoao_sena.libraryapi.model.Autor;

import java.util.UUID;

public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
