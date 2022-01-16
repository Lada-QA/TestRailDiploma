package adapters;

import objects.Suite;

public class SuitesAdapter extends BaseAdapter {

    public int createSuite(Suite suite, int projectId) {
        return post(String.format(ADD_SUITE_API, projectId), this.converter.toJson(suite)).body().path("id");
    }

    public String getSuite(int projectId) {
        return this.get(String.format(GET_SUITE_API, projectId)).asString();
    }

}