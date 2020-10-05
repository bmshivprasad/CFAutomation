package cleanfill.PageObjects;

public interface Validations {

    String REQUIRED = "Required";
    String PAST_DATE = "Date must be greater than or equal to today";
    String INVALID_DATE = "Invalid Date";

    String VALUE_MORE_THAN_1 = "Value must be greater than 1";
    String VALUE_MORE_THAN_50 = "No more than 50 characters are required";

    default String duplicateBatchName(String batchName) {
        return "Batch name '" + batchName + "' is already taken";
    }

}
