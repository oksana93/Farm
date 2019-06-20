package farm.dairy.cow.controller;

import farm.dairy.cow.dto.CowDto;
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
    public void addCalfToCow(@RequestBody CowDto cowDto) throws Exception {
        cowValidate.validateAddCalfToCow(cowDto);
        cowService.addCalfToCow(cowDto);
    }

    @PostMapping(value = "/delete", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void setEndLifeToCowByCow(@RequestBody CowDto cowDto) throws Exception {
        cowValidate.validateSetEndLifeToCowByCow(cowDto);
        cowService.setEndLifeToCowByCowId(cowDto);
    }

    @GetMapping(value = "/cows")
    public FarmCows getCowInfo() {
        return cowService.getCowDtoBy();
    }

}
