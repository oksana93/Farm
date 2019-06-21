package farm.dairy.cow.service;

import farm.dairy.cow.dto.*;
import farm.dairy.cow.model.Cow;
import farm.dairy.cow.model.CowStream;
import farm.dairy.cow.repository.CowRepository;
import farm.dairy.cow.repository.CowStreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class CowServiceImpl implements CowService {
    @Autowired
    protected CowRepository cowRepository;
    @Autowired
    protected CowStreamRepository cowStreamRepository;

    public void addCalfToCow(CowWithStructureStream cowDto) throws Exception {
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

    public void setEndLifeToCowByCowId(CowWithStructureStream cowDto) throws Exception {
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

    public FarmCows getCows() {
        List<Cow> cowList = cowRepository.findAll();
        return new FarmCows(
                cowList.stream()
                        .map(CowWithStructure::new)
                        .collect(Collectors.toList()));
    }

    public FarmCowsStream getStreamCows() {
        Iterable<CowStream> cowsIterable = cowStreamRepository.findAll();
        Stream<CowStream> cowsStream = StreamSupport.stream(
                cowsIterable.spliterator(), true);
        Stream<CowWithStructureStream> cowWithStructureStream = cowsStream.map(CowWithStructureStream::new);
        return new FarmCowsStream(cowWithStructureStream);
    }
}
