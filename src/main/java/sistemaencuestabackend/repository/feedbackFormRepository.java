package sistemaencuestabackend.repository;

import sistemaencuestabackend.model.feedbackForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface feedbackFormRepository extends JpaRepository<feedbackForm,Long> {
    public Optional<feedbackForm> findById(Long id);

    @Query(value = "SELECT * FROM  formulario_encuesta e where e.eliminar is null ",nativeQuery = true)
    public List<feedbackForm> findNullEliminar();

    boolean existsByIdAndDeleted(Long id,Object o);
}
