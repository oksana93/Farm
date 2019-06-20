package farm.dairy.cow.repository;

import farm.dairy.cow.model.Cow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CowRepository extends JpaRepository<Cow, UUID> {
}

