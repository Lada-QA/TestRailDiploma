package steps;

import adapters.PlanAdapter;
import com.google.gson.Gson;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects_for_plan.Entries;
import objects_for_plan.TestPlan;
import org.testng.Assert;

import java.util.ArrayList;

import static steps.HomePageSteps.ID_NEW_PROJECT_FROM_API;
import static steps.HomePageSteps.ID_SUITE_FROM_API;


public class PlanSteps {
    public static int PLAN_ID_FROM_API;

    @When("User send POST request for add new test plan {string}")
    public void userSendPOSTRequestForAddNewTestPlanSystemTest(String nameTestPlan) {
        Entries entries = new Entries();
        entries.setSuiteId(ID_SUITE_FROM_API);
        entries.setName("Custom run name");
        entries.setAssignedtoId(1);
        TestPlan testPlan = TestPlan.builder()
                .name(nameTestPlan)
                .build();
        ArrayList<Entries> entriesList1 = new ArrayList<>();
        entriesList1.add(entries);
        testPlan.setEntries(entriesList1);
        PLAN_ID_FROM_API = new PlanAdapter().addTestPlan(testPlan, ID_NEW_PROJECT_FROM_API);
    }

    @Then("Verify test plan is created successfully via API")
    public void verifyTestPlanIsCreatedSuccessfullyViaAPI() {
        String body = new PlanAdapter().getTestPlan(PLAN_ID_FROM_API);
        TestPlan testPlan = new Gson().fromJson(body, TestPlan.class);
        int idFromApi = testPlan.getId();
        Assert.assertEquals(testPlan.getId(), idFromApi);
    }
}