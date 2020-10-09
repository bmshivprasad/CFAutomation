package cleanfill.PageObjects;

public interface Validations {

    String REQUIRED = "Required";
    String PAST_DATE = "Date must be greater than or equal to today";
    String INVALID_DATE = "Invalid Date";

    String VALUE_MORE_THAN_1 = "Value must be greater than 1";
    String VALUE_MORE_THAN_50 = "No more than 50 characters are required";

    String DELETE_LINK_MESSAGE = "Are you sure you want to Delete?";
    String LINKS_MORE_THAN_3 = "You can only add up to 3 links per batch.";

    String FILE_MORE_THAN_10MB = "Http failure response for https://cleanfill-qa.azurewebsites.net/api/Batches/Attachment: 400 Bad Request";
    String FILES_MORE_THAN_5 = "Cannot upload more than 5 documents";

    String BATCH_REQUEST_SUCCESS = "Batch Request Submitted!";

    String STATUS_PENDING_RECEIVING_SITE = "Pending: Receiving Site";

    default String duplicateBatchName(String batchName) {
        return "Batch name '" + batchName + "' is already taken";
    }

}
