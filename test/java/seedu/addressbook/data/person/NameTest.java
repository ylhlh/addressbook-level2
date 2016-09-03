package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;

public class NameTest {
    
    private Name name1;
    private Name name2;
    
    @Test
    public void testIsSimilar() {
        
        try {
            
            // names are completely equal
            name1 = new Name("Bob");
            name2 = new Name("Bob");
            assertTrue(name1.isSimilar(name2));
            
            // names are equal when ignoring case
            name1 = new Name("Bob");
            name2 = new Name("bob");
            assertTrue(name1.isSimilar(name2));

            // names are completely different
            name1 = new Name("John Smith");
            name2 = new Name("Bobby");
            assertFalse(name1.isSimilar(name2));
            
            // names are in different order
            name1 = new Name("John Smith");
            name2 = new Name("Smith John");
            assertTrue(name1.isSimilar(name2));
            
            // names in different order, and different case
            name1 = new Name("JoHn k SmiTh");
            name2 = new Name("Smith K JOHN");
            assertTrue(name1.isSimilar(name2));
            
            // name1 is subset of name2
            name1 = new Name("John");
            name2 = new Name("John Smith");
            assertTrue(name1.isSimilar(name2));
            
            // name1 is not subset of name2
            name1 = new Name("John Bobby");
            name2 = new Name("John Smith");
            assertFalse(name1.isSimilar(name2));
            
            // name1 is superset of name2
            name1 = new Name("John Kill");
            name2 = new Name("John");
            assertTrue(name1.isSimilar(name2));
            
            // name2 is null
            name1 = new Name("Doesnt matter");
            assertFalse(name1.isSimilar(null));
            
        } catch (IllegalValueException e) {
            System.out.println("Should not reach here!");
        }
        
    }

}
