package seedu.addressbook.data.person.address;

public class Block {
    private String value;
    
    public Block(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
