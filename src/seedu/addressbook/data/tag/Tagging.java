package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

/**
 * Each Tagging object represents an adding or deleting of a tag 
 * for a specific person that happened during that session.
 */
public class Tagging {
    
    private final Person person;
    private final Tag tag;
    private String operationType;
    
    public Tagging(Person person, Tag tag, String operationType) {
        this.person = person;
        this.tag = tag;
        this.operationType = operationType;
    }
    
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(operationType)
               .append(" ")
               .append(person.getName())
               .append(" ")
               .append(tag);
        return builder.toString();
    }
}
