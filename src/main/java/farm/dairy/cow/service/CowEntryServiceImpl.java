package farm.dairy.cow.service;

import farm.dairy.cow.dto.CowDto;
import farm.dairy.cow.dto.CowEntry;
import farm.dairy.cow.repository.CowStorage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CowEntryServiceImpl implements CowEntryService {
    protected CowEntry COW_ENTRY;

    public CowEntryServiceImpl() {
        this.COW_ENTRY = CowStorage.COW_ENTRY;
    }

    public CowEntryServiceImpl(CowEntry COW_ENTRY) {
        this.COW_ENTRY = COW_ENTRY;
    }

    public void addCalfToCow(String calfNickName, CowDto parentCow) throws Exception {
        CowEntry existedCowParent = findExistedCowEntryByCowDto(parentCow);
        CowEntry calfEntry = new CowEntry(calfNickName);
        existedCowParent.setDaughter(calfEntry);
    }

    public void addCalfToCow(CowDto calf, CowDto parentCow) throws Exception {
        CowEntry existedCowParent = findExistedCowEntryByCowDto(parentCow);
        CowEntry calfEntry = new CowEntry(calf);
        existedCowParent.setDaughter(calfEntry);
    }

    public void setEndLifeToCowByCowId(CowDto cowDto) throws Exception {
        CowEntry existedCow = findExistedCowEntryByCowDto(cowDto);
        setDeathDateToCowEntry(existedCow);
    }

    private CowEntry findExistedCowEntryByCowDto(CowDto parentCow) throws Exception {
        CowEntry existedCowParent = COW_ENTRY.findParentCowEntryByCowDtoRelativeThisRoot(parentCow);
        if (existedCowParent == null)
            throw new Exception("Cow does not exist");
        CowDto existedCow = existedCowParent.getCow();
        if (existedCow.getDateDeath() != null)
            throw new Exception("The cow is dead");
        return existedCowParent;
    }

    private void setDeathDateToCowEntry(CowEntry existedCow) {
        CowDto cow = existedCow.getCow();
        cow.setDateDeath(LocalDateTime.now());
    }

    public void printAllCow() {
        COW_ENTRY.printCowEntryRelativeThisRoot();
    }
}
