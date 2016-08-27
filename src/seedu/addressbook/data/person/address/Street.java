package seedu.addressbook.data.person.address;

public class Street {
    private String value;

    public Street(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
