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
            
            
        } catch (IllegalValueException e) {
            System.out.println("Should not reach here!");
        }
        
    }

}
