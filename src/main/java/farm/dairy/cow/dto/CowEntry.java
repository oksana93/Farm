package farm.dairy.cow.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class CowEntry {
    @Getter
    @Setter
    private CowDto cow;
    @Getter
    @Setter
    private CowEntry firstYoungerSister;
    @Getter
    @Setter
    private CowEntry firstDaughter;

    public CowEntry(CowDto cow) {
        this.cow = cow;
    }

    public CowEntry(String nickName) {
        cow = new CowDto(nickName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CowEntry cowEntry = (CowEntry) obj;
        return cow.equals(cowEntry.cow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cow);
    }

    @Override
    public String toString() {
        return cow.toString();
    }

    public CowEntry findParentCowEntryByCowDtoRelativeThisRoot(CowDto searchParentCowDto) {
        if (searchParentCowDto == null)
            return null;
        return findCowAmongDaughter(searchParentCowDto);
    }

    private CowEntry findCowAmongDaughter(CowDto searchCow) {
        if (cow.getCowId().equals(searchCow.getCowId()))
            return this;

        CowEntry foundCow = null;
        if (firstDaughter != null)
            foundCow = firstDaughter.findCowAmongDaughter(searchCow);
        if (foundCow == null && firstYoungerSister != null)
            foundCow = firstYoungerSister.findCowAmongDaughter(searchCow);
        return foundCow;
    }

    public void setDaughter(CowEntry calfEntry) {
        if (firstDaughter == null)
            firstDaughter = calfEntry;
        else
            firstDaughter.setSister(calfEntry);
    }

    private void setSister(CowEntry calfEntry) {
        if (firstYoungerSister == null)
            firstYoungerSister = calfEntry;
        else
            firstYoungerSister.setSister(calfEntry);
    }

    public void printCowEntryRelativeThisRoot() {
        System.out.println("\n--Cows--");
        int tabInt = 0;
        printDaughter(tabInt);
    }

    private void printDaughter(int tabInt) {
        printWithTab(tabInt);
        if (firstDaughter != null)
            firstDaughter.printDaughter(tabInt + 1);
        if (firstYoungerSister != null)
            firstYoungerSister.printDaughter(tabInt);
    }

    private void printWithTab(int tabInt) {
        for (int i = 0; i < tabInt; i++)
            System.out.print("\t");
        System.out.println(toString());
    }
}
