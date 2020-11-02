package cleanfill.PageObjects;

public interface Validations {

    String REQUIRED = "Required";
    String PAST_DATE = "Date must be greater than or equal to today";
    String INVALID_DATE = "Invalid Date";

    String ESTIMATED_WEIGHT_VOLUME_MANDATORY = "Value must be greater than 1";

    String SOIL_QUALITY_MANDATORY = "Required if available. Or, select the no analysis option";

    String VALUE_MORE_THAN_1 = "Value must be greater than 1";
    String VALUE_MORE_THAN_50 = "No more than 50 characters are required";

    String DELETE_LINK_MESSAGE = "Are you sure you want to Delete?";
    String LINKS_MORE_THAN_3 = "You can only add up to 3 links per batch.";

    String FILE_MORE_THAN_10MB = "Cannot upload a file bigger than 10mb";
    String FILES_MORE_THAN_5 = "Cannot upload more than 5 documents";

    String BATCH_REQUEST_SUCCESS = "Batch Request Submitted!";
    String BATCH_REQUEST_SAVED = "Batch Request Saved!";

    String STATUS_PENDING_RECEIVING_SITE = "Pending: Receiving Site";
    String STATUS_DRAFT = "Draft";

    default String duplicateBatchName(String batchName) {
        return "Batch name '" + batchName + "' is already taken";
    }

    String PASSWORD_VALIDATION = "Your password must have at least 3 of the following:\n" +
            "  - a lowercase letter\n" +
            "  - an uppercase letter\n" +
            "  - a number\n" +
            "  - a symbol";
    String PASSWORD_CHARACTER_VALIDATION = "The password must be between 8 and 64 characters.";
    String PASSWORD_MISMATCH_VALIDATION = "The password entry fields do not match. Please enter the same password in both fields and try again.";
}
