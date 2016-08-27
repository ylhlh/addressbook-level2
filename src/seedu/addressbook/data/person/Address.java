package seedu.addressbook.data.person;

import java.util.Objects;

import seedu.addressbook.data.person.address.Block;
import seedu.addressbook.data.person.address.PostalCode;
import seedu.addressbook.data.person.address.Street;
import seedu.addressbook.data.person.address.Unit;
import seedu.addressbook.data.tag.Tag;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person address is entered in this format: a/BLOCK, STREET, UNIT, POSTAL_CODE";

    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;
    public String value;
    /**
     * Assumption: Every field must be present and not null.
     * Input entered in the order BLOCK, STREET, UNIT, POSTAL_CODE
     */
    public Address(Block block, Street street, Unit unit, PostalCode postalCode, boolean isPrivate) {
        this.isPrivate = isPrivate;
        this.block = block;
        this.street = street;
        this.unit = unit;
        this.postalCode = postalCode;
        value = buildAddressString();
    }
    
    public Address(String value, boolean isPrivate) {
        this.isPrivate = isPrivate;
        this.value = value;
        String[] Address = value.split(", ");
        block = new Block(Address[0]);
        street = new Street(Address[1]);
        unit = new Unit(Address[2]);
        postalCode = new PostalCode(Address[3]);
    }
    
    public Block getBlock() {
        return block;
    }
    
    public Street getStreet() {
        return street;
    }
    
    public Unit getUnit() {
        return unit;
    }
    
    public PostalCode getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && ((Address) other).getBlock().equals(this.getBlock()) // state checks here onwards
                && ((Address) other).getStreet().equals(this.getStreet())
                && ((Address) other).getUnit().equals(this.getUnit())
                && ((Address) other).getPostalCode().equals(this.getPostalCode()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(block, street, unit, postalCode);
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }
    
    public String buildAddressString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getBlock())
               .append(", ")
               .append(getStreet())
               .append(", ")
               .append(getUnit())
               .append(", ")
               .append(getPostalCode());
        return builder.toString();
    }
    
}