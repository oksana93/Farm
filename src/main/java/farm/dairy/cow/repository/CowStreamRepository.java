package farm.dairy.cow.repository;

import farm.dairy.cow.model.CowStream;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CowStreamRepository extends CrudRepository<CowStream, UUID> {
}

