package cl.benavidesgonzalo.globallogic.desafiobci.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepo extends JpaRepository<User,Long>{

    @NonNull
    public Optional<User> findById(@NonNull Long id);
    public Optional<User> findByName(String name);
    public Optional<User> findByEmail(String email);
    public Optional<User> findByToken(String token);
}
