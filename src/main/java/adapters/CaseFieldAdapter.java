package adapters;

import objects_for_case_field.CaseField;

public class CaseFieldAdapter extends BaseAdapter {

    public String createNewCaseField(CaseField caseField) {
        return post(ADD_CASE_FIELD_API, this.converter.toJson(caseField)).body().asString();
    }
}
