package farm.dairy.cow.controller;

import farm.dairy.cow.dto.CowWithParentAndCalvesDto;
import farm.dairy.cow.dto.FarmCows;
import farm.dairy.cow.service.CowService;
import farm.dairy.cow.validate.CowValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CowController {
    @Autowired
    protected CowValidate cowValidate;
    @Autowired
    protected CowService cowService;

    @PutMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void addCalfToCow(@RequestBody CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception {
        cowValidate.validateAddCalfToCow(cowWithParentAndCalvesDto);
        cowService.addCalfToCow(cowWithParentAndCalvesDto);
    }

    @PostMapping(value = "/delete", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void setEndLifeToCowByCow(@RequestBody CowWithParentAndCalvesDto cowWithParentAndCalvesDto) throws Exception {
        cowValidate.validateSetEndLifeToCowByCow(cowWithParentAndCalvesDto);
        cowService.setEndLifeToCowByCowId(cowWithParentAndCalvesDto);
    }

    @GetMapping(value = "/cows")
    public FarmCows getCowInfo() {
        return cowService.getCowDtoBy();
    }

}
