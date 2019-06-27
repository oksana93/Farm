package farm.dairy.cow.controller;

import farm.dairy.cow.dto.CowWithParentAndCalvesDto;
import farm.dairy.cow.service.CowEntryService;
import farm.dairy.cow.validate.CowValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CowEntryController {
    @Autowired
    protected CowValidate cowValidate;
    @Autowired
    protected CowEntryService cowEntryService;

    @PutMapping(value = "/addEntry", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void addCalfToCow(@RequestBody CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception {
        cowValidate.validateAddCalfToCow(cowWithParentAndCalvesDto);
        cowEntryService.addCalfToCow(
                cowWithParentAndCalvesDto.getNickName(),
                cowWithParentAndCalvesDto.getParentCow());
    }

    @PostMapping(value = "/removeEntry", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void setEndLifeToCowByCow(@RequestBody CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception {
        cowValidate.validateSetEndLifeToCowByCow(cowWithParentAndCalvesDto);
        cowEntryService.setEndLifeToCowByCowId(cowWithParentAndCalvesDto);
    }

    @GetMapping(value = "/cowsEntry")
    public void getCowInfo() {
        cowEntryService.printAllCow();
    }

}
