package adapters;

import io.restassured.RestAssured;
import objects_for_case_field.CaseField;

public class CaseFieldAdapter extends BaseAdapter {

    public int createNewCaseField(CaseField caseField) {
        return post(ADD_CASE_FIELD_API, this.converter.toJson(caseField)).getStatusCode();
    }

    public int getStatusCode() {
        return RestAssured.get(GET_CASE_FIELD_API).getStatusCode();
    }
}
