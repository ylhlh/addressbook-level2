package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import java.util.Arrays;
import java.util.List;

/**
 * Represents a Person's name in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidName(String)}
 */
public class Name {

    public static final String EXAMPLE = "John Doe";
    public static final String MESSAGE_NAME_CONSTRAINTS = "Person names should be spaces or alphabetic characters";
    public static final String NAME_VALIDATION_REGEX = "[\\p{Alpha} ]+";

    public final String fullName;

    /**
     * Validates given name.
     *
     * @throws IllegalValueException if given name string is invalid.
     */
    public Name(String name) throws IllegalValueException {
        name = name.trim();
        if (!isValidName(name)) {
            throw new IllegalValueException(MESSAGE_NAME_CONSTRAINTS);
        }
        this.fullName = name;
    }

    /**
     * Returns true if a given string is a valid person name.
     */
    public static boolean isValidName(String test) {
        return test.matches(NAME_VALIDATION_REGEX);
    }

    /**
     * Retrieves a listing of every word in the name, in order.
     */
    public List<String> getWordsInName() {
        return Arrays.asList(fullName.split("\\s+"));
    }

    @Override
    public String toString() {
        return fullName;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Name // instanceof handles nulls
                && this.fullName.equals(((Name) other).fullName)); // state check
    }

    @Override
    public int hashCode() {
        return fullName.hashCode();
    }
    
    /**
     * Returns true if the other name is very similar to this name.
     * Two names are considered similar if they are equal ignoring case,
     *  
     */
     public boolean isSimilar(Name other) { 
         String thisName = this.fullName;
         String otherName = other.fullName;
         thisName = thisName.toLowerCase();
         otherName = otherName.toLowerCase();
         
         if (thisName.equals(otherName)) {
             return true;
         }
         
         String[] thisNameSplit = thisName.split(" ");
         String[] otherNameSplit = otherName.split(" ");
         String thisNameSorted = "";
         String otherNameSorted = "";
         Arrays.sort(thisNameSplit);
         Arrays.sort(otherNameSplit);
         for (int i = 0; i < thisNameSplit.length; i++) {
             thisNameSorted += thisNameSplit[i];
         }
         for (int i = 0; i < otherNameSplit.length; i++) {
             otherNameSorted += otherNameSplit[i];
         }
         
         if (thisNameSorted.equals(otherNameSorted)) {
             return true;
         }
         
         return false;
     }

}
