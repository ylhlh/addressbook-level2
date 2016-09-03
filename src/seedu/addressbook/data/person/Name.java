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
     * Two names are considered similar if they are: (ignoring case)
     * equal, in different order, or if one name is a subset of the other name.
     * Note that the subset definition we use includes the former two cases as well.
     */
     public boolean isSimilar(Name other) { 
         if (other == null) {
             return false;
         }
         String thisNameIgnoreCase = this.fullName.toLowerCase();
         String otherNameIgnoreCase = other.fullName.toLowerCase();

         return isOneNameSubsetOfTheOther(thisNameIgnoreCase, otherNameIgnoreCase);
     }

    /**
     * Given two names, check if one name is subset of the other name.
     * Subset definition also returns true if the names are equal, or in different order.
     * @param thisNameIgnoreCase this name converted to lower case
     * @param otherNameSplit other name converted to lower case
     * @return true if one name is subset of the other, else false.
     */
    private boolean isOneNameSubsetOfTheOther(String thisNameIgnoreCase, String otherNameIgnoreCase) {
        String[] thisNameSplit = thisNameIgnoreCase.split(" ");
        String[] otherNameSplit = otherNameIgnoreCase.split(" ");
        Arrays.sort(thisNameSplit);
        Arrays.sort(otherNameSplit);
        int lengthOfNameWithLessWords = Math.min(thisNameSplit.length, otherNameSplit.length);
        for (int i = 0; i < lengthOfNameWithLessWords; i++) {
            if (!thisNameSplit[i].equals(otherNameSplit[i])) {
                return false;
            }
        }
        return true;
    }

}
