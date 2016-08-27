package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

import java.util.List;

public class Formatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";
    
    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";
    
    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    public static String addLinePrefix(String toFormat) {
        return LINE_PREFIX + toFormat;
    }
    
    public static String wrapInCommandEnteredBlock(String toFormat) {
        return LINE_PREFIX + "[Command entered:" + toFormat + "]" + "\n";
    }
    
    public static String formatWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        String message = addDecorationsToText(
                DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER);
        return message;
    }
    
    public static String formatGoodbyeMessage() {
        String message = addDecorationsToText(
                MESSAGE_GOODBYE, DIVIDER, DIVIDER);
        return message;
    }
    
    public static String formatInitFailedMessage() {
        String message = addDecorationsToText(
                MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
        return message;
    }
    
    public static String formatFeedbackForDisplay(String feedbackToUser) {
        String message = addDecorationsToText(
                feedbackToUser, DIVIDER);
        return message;
    }
    
    private static String addDecorationsToText(String... message) {
        final StringBuilder toShow = new StringBuilder();
        for (String m : message) {
            toShow.append(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX)).append("\n");
        }
        return toShow.toString();
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public static String formatIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(LINE_PREFIX).append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        formatted.append(LINE_PREFIX + "\n");
        return formatted.toString();
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
