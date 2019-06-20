package farm.dairy.cow.service;

import farm.dairy.cow.dto.CowDto;
import farm.dairy.cow.dto.CowWithParentAndCalvesDto;
import farm.dairy.cow.dto.FarmCows;
import farm.dairy.cow.model.Cow;
import farm.dairy.cow.repository.CowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CowServiceImpl implements CowService {
    @Autowired
    protected CowRepository cowRepository;

    public void addCalfToCow(CowWithParentAndCalvesDto cowDto) throws Exception {
        CowDto parentCow = cowDto.getParentCow();
        Cow calf = getCalfByParentAndCalfName(
                parentCow.getCowId(),
                cowDto.getNickName());
        cowRepository.save(calf);
    }

    private Cow getCalfByParentAndCalfName(UUID parentCowId, String calfNickName) throws Exception {
        Cow parentCow = getCowById(parentCowId);
        checkCowIsAlive(parentCow);
        return new Cow(calfNickName, parentCow);
    }

    private void checkCowIsAlive(Cow cow) throws Exception {
        if (Objects.nonNull(cow.getDateDeath()))
            throw new Exception("The cow is dead");
    }

    public void setEndLifeToCowByCowId(CowWithParentAndCalvesDto cowDto) throws Exception {
        Cow cow = getCowById(cowDto.getCowId());
        setEndLifeToCow(cow);
    }

    private Cow getCowById(UUID parentCowId) throws Exception {
        Optional<Cow> cow = cowRepository.findById(parentCowId);
        return cow.orElseThrow(() -> new Exception("Cow does not exist"));
    }

    private void setEndLifeToCow(Cow cow) {
        cow.setDateDeath(LocalDateTime.now());
        cowRepository.save(cow);
    }

    public FarmCows getAllCow() {
        List<Cow> cowList = cowRepository.findAll();
        return new FarmCows(
                cowList.stream()
                        .map(cow -> new CowWithParentAndCalvesDto(cow))
                        .collect(Collectors.toList()));
    }
}
