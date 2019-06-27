package farm.dairy.cow.repository;

import farm.dairy.cow.dto.CowDto;
import farm.dairy.cow.dto.CowEntry;

import java.util.UUID;

public interface CowStorage {
    CowEntry COW_ENTRY = new CowEntry(new CowDto(
            UUID.fromString("2f1d156b-8dc2-4fc2-bb8c-95613f7d5251"),
            "Mum"));
}
