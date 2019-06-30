package farm.dairy.cow;

import farm.dairy.cow.dto.CowDto;
import farm.dairy.cow.service.CowEntryService;
import farm.dairy.cow.service.CowEntryServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {CowEntryServiceImpl.class})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class FarmEntryApplicationTest {

    @Autowired
    private CowEntryService cowEntryService;

    @Test
    public void entryTest() throws Exception {
        System.out.println("\nTest 1");

        cowEntryService.printAllCow();
        CowDto cowMum = new CowDto(UUID.fromString("2f1d156b-8dc2-4fc2-bb8c-95613f7d5251"), "Mum");
        CowDto calfFirst = new CowDto(UUID.fromString("2757a9b2-0987-432f-9e12-2335ef90d308"), "Calf 1");
        CowDto calfSecond = new CowDto(UUID.fromString("d826e09c-d902-4e92-917b-1cd5de331c84"), "Calf 2");
        CowDto calfThird = new CowDto(UUID.fromString("db59ddc7-431f-492f-80b4-d10fe2bde870"), "Calf 3");
        CowDto calfFourths = new CowDto(UUID.fromString("b51f0f3e-e474-4d13-8cb0-a2a7a1511910"), "Calf 4");
        CowDto calfFifth = new CowDto(UUID.fromString("16e80045-6995-4359-8017-6ed99a8466f4"), "Calf 5");
        CowDto calfSixth = new CowDto(UUID.fromString("96cf5311-3cba-491c-936f-b20f20c5e53d"), "Calf 6");
        CowDto calfSeventh = new CowDto(UUID.fromString("480d4d74-e010-4986-8e0f-60b574c14cf7"), "Calf 7");

        cowEntryService.addCalfToCow(calfFirst, cowMum);
        cowEntryService.printAllCow();

        cowEntryService.addCalfToCow(calfSecond, cowMum);
        cowEntryService.printAllCow();

        cowEntryService.addCalfToCow(calfThird, cowMum);
        cowEntryService.printAllCow();

        cowEntryService.addCalfToCow(calfFourths, calfThird);
        cowEntryService.printAllCow();

        cowEntryService.addCalfToCow(calfFifth, calfFourths);
        cowEntryService.printAllCow();

        cowEntryService.addCalfToCow(calfSixth, cowMum);
        cowEntryService.printAllCow();

        cowEntryService.setEndLifeToCowByCowId(calfThird);

        try {
            System.out.println("\nSet calf to \'closed\' cow");
            cowEntryService.addCalfToCow(calfSeventh, calfThird);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        cowEntryService.printAllCow();
    }

    @Test
    public void entryTestSecond() throws Exception {
        System.out.println("\nTest 2");

        cowEntryService.printAllCow();
        CowDto cowMum = new CowDto(UUID.fromString("2f1d156b-8dc2-4fc2-bb8c-95613f7d5251"), "Mum");
        CowDto calfFirst = new CowDto(UUID.fromString("2757a9b2-0987-432f-9e12-2335ef90d308"), "Calf 1");
        CowDto calfSecond = new CowDto(UUID.fromString("d826e09c-d902-4e92-917b-1cd5de331c84"), "Calf 2");
        CowDto calfThird = new CowDto(UUID.fromString("db59ddc7-431f-492f-80b4-d10fe2bde870"), "Calf 3");
        CowDto calfFourths = new CowDto(UUID.fromString("b51f0f3e-e474-4d13-8cb0-a2a7a1511910"), "Calf 4");

        cowEntryService.addCalfToCow(calfFirst, cowMum);
        cowEntryService.addCalfToCow(calfSecond, cowMum);
        cowEntryService.addCalfToCow(calfThird, calfFirst);
        cowEntryService.addCalfToCow(calfFourths, calfSecond);

        cowEntryService.printAllCow();
    }

    @Test
    public void entryTestThird() throws Exception {
        System.out.println("\nTest 3");

        cowEntryService.printAllCow();
        CowDto cowMum = new CowDto(UUID.fromString("2f1d156b-8dc2-4fc2-bb8c-95613f7d5251"), "Mum");
        CowDto calfFirst = new CowDto(UUID.fromString("2757a9b2-0987-432f-9e12-2335ef90d308"), "Calf 1");
        CowDto calfSecond = new CowDto(UUID.fromString("d826e09c-d902-4e92-917b-1cd5de331c84"), "Calf 2");
        CowDto calfThird = new CowDto(UUID.fromString("db59ddc7-431f-492f-80b4-d10fe2bde870"), "Calf 3");
        CowDto calfFourths = new CowDto(UUID.fromString("b51f0f3e-e474-4d13-8cb0-a2a7a1511910"), "Calf 4");
        CowDto calfFifth = new CowDto(UUID.fromString("16e80045-6995-4359-8017-6ed99a8466f4"), "Calf 5");
        CowDto calfSixth = new CowDto(UUID.fromString("96cf5311-3cba-491c-936f-b20f20c5e53d"), "Calf 6");
        CowDto calfSeventh = new CowDto(UUID.fromString("480d4d74-e010-4986-8e0f-60b574c14cf7"), "Calf 7");

        cowEntryService.addCalfToCow(calfFirst, cowMum);
        cowEntryService.addCalfToCow(calfSecond, calfFirst);

        cowEntryService.setEndLifeToCowByCowId(calfSecond);
        try {
            System.out.println("\nSet calf to \'closed\' cow");
            cowEntryService.addCalfToCow(calfThird, calfSecond);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        cowEntryService.addCalfToCow(calfThird, calfFirst);
        cowEntryService.addCalfToCow(calfFourths, calfFirst);
        cowEntryService.addCalfToCow(calfFifth, cowMum);
        cowEntryService.addCalfToCow(calfSixth, calfThird);
        cowEntryService.addCalfToCow(calfSeventh, calfThird);

        cowEntryService.printAllCow();
    }
}
