package sistemaencuestabackend.repository;

import sistemaencuestabackend.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<user,Long> {
    public user findByUsername(String name);
    public Optional<user> findById(Long id);

    boolean existsById(Long id);
}
