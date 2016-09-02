package seedu.addressbook.common;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.Collection;
import java.util.ArrayList;
import java.lang.Integer;

import org.junit.Test;

public class UtilsTest {

    @Test
    public void isAnyNull_multipleArgumentsNull_trueReturned() {
        assertTrue(Utils.isAnyNull(null, null, null, null));
    }
    
    @Test
    public void isAnyNull_multipleArgumentsObjects_falseReturned() {
        assertFalse(Utils.isAnyNull(new Object(), new String(), new Object()));
    }
    
    @Test
    public void isAnyNull_multipleArgumentsNullAndObjects_trueReturned() {
        assertTrue(Utils.isAnyNull(new Object(), new String(), null, null));
    }
    
    @Test
    public void isAnyNull_emptyArgument_falseReturned() {
        assertFalse(Utils.isAnyNull());
    }
    
    @Test (expected = NullPointerException.class)
    public void isAnyNull_singleArgumentNull_nullPointerExceptionThrown() {
        Utils.isAnyNull(null);
    }

    @Test
    public void elementsAreUnique_differentClassesElements_trueReturned() {
        Collection<Object> items = new ArrayList<Object>();
        items.add(new Object());
        items.add(new String());
        items.add(new Integer(1));
        assertTrue(Utils.elementsAreUnique(items));
    }

    @Test
    public void elementsAreUnique_uniqueStringElements_trueReturned() {
        Collection<Object> items = new ArrayList<Object>();
        items.add("a");
        items.add("bb");
        items.add("ccc");
        assertTrue(Utils.elementsAreUnique(items));
    }
    
    @Test
    public void elementsAreUnique_sameStringElements_falseReturned() {
        Collection<Object> items = new ArrayList<Object>();
        items.add("a");
        items.add("a");
        items.add("a");
        assertFalse(Utils.elementsAreUnique(items));
    }
    
    @Test
    public void elementsAreUnique_pairOfSameIntegerElementsAmongUniqueElements_falseReturned() {
        Collection<Object> items = new ArrayList<Object>();
        items.add(new Integer(1));
        items.add(new Integer(2));
        items.add(new Integer(3));
        items.add(new Integer(4));
        items.add(new Integer(4));
        assertFalse(Utils.elementsAreUnique(items));
    }
    
    @Test (expected = NullPointerException.class)
    public void elementsAreUnique_argumentNull_nullPointerExceptionThrown() {
        Utils.elementsAreUnique(null);
    }
    
}
