package cl.benavidesgonzalo.globallogic.desafiobci.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PhoneRepo extends JpaRepository<Phone, Long>{

    @NonNull
    public Optional<Phone> findById(@NonNull Long id);
    public List<Phone> findByUser(User user);
    
}
