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
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
                && this.value.equals(((Unit) other).value)); // state check
    }
}
