package seedu.addressbook.data.person;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NameTest {
    
    private Name name1;
    private Name name2;
    
    @Test
    public void testIsSimilar() {
        // names are completely equal
        name1 = new Name("Bob");
        name2 = new Name("Bob");
        assertTrue(name1.isSimilar(name2));
    }

}
