package adapters;

import objects_for_plan.TestPlan;


public class PlanAdapter extends BaseAdapter {

    public int addTestPlan(TestPlan testPlan, int projectId) {
        return post(String.format(ADD_TEST_PLAN_API, projectId), this.converter.toJson(testPlan)).body().path("id");
    }

    public String getTestPlan(int planId) {
        return this.get(String.format(GET_TEST_PLAN_API, planId)).body().asString();
    }
}
