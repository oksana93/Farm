package farm.dairy.cow.controller;

import farm.dairy.cow.dto.CowWithStructureStream;
import farm.dairy.cow.dto.FarmCows;
import farm.dairy.cow.dto.FarmCowsStream;
import farm.dairy.cow.service.CowService;
import farm.dairy.cow.validate.CowValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/farm")
public class CowController {
    @Autowired
    protected CowValidate cowValidate;
    @Autowired
    protected CowService cowService;

    @PutMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void addCalfToCow(@RequestBody CowWithStructureStream cowWithStructureStream) throws Exception {
        cowValidate.validateAddCalfToCow(cowWithStructureStream);
        cowService.addCalfToCow(cowWithStructureStream);
    }

    @PostMapping(value = "/remove", produces = {MediaType.APPLICATION_JSON_VALUE})
    public void setEndLifeToCowByCow(@RequestBody CowWithStructureStream cowWithStructureStream) throws Exception {
        cowValidate.validateSetEndLifeToCowByCow(cowWithStructureStream);
        cowService.setEndLifeToCowByCowId(cowWithStructureStream);
    }

    @GetMapping(value = "/cows")
    public FarmCows getCowsInfo() {
        return cowService.getCows();
    }

    @GetMapping(value = "/stream/cows")
    public FarmCowsStream getStreamCowsInfo() {
        return cowService.getStreamCows();
    }

}
