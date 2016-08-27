package seedu.addressbook.data.person.address;

public class PostalCode {
    private String value;

    public PostalCode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
