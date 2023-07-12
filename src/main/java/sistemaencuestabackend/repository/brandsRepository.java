package sistemaencuestabackend.repository;

import sistemaencuestabackend.model.brands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface brandsRepository extends JpaRepository<brands,Long> {
    public List<brands> findAll();
}
