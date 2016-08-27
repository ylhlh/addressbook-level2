package seedu.addressbook.data.person.address;

public class Unit {
    private String value;

    public Unit(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
