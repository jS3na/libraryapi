package shop.devjoao_sena.libraryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.devjoao_sena.libraryapi.model.Livro;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
