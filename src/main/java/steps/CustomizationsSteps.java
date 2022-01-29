package steps;

import adapters.CaseFieldAdapter;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objects_for_case_field.CaseField;
import objects_for_case_field.Configs;
import objects_for_case_field.Context;
import objects_for_case_field.Options;
import org.testng.Assert;

import java.util.ArrayList;

import static utils.Random.RANDOM_NAME;
import static utils.Random.createRandomName;

public class CustomizationsSteps extends AbstractSteps{
    public static String TYPE_CASE_FIELD;
    public static String ITEMS_CASE_FIELD;

    @When("User send POST request for add new case field with Random name")
    public void userSendPostRequestForAddNewCaseField() {
        createRandomName();
        Configs configs = new Configs();
        Context context = new Context();
        Options options = new Options();
        context.setGlobal(true);
        context.setProjectIds("5");
        configs.setContext(context);
        options.setRequired(false);
        options.setItems("1, One\n2, Two");
        configs.setOptions(options);
        CaseField caseField = CaseField.builder()
                .type("Multiselect")
                .name(RANDOM_NAME)
                .label("My Multiselect")
                .description("my custom Multiselect description")
                .includeAll(true)
                .build();
        ArrayList<Configs> configsList = new ArrayList<>();
        configsList.add(configs);
        caseField.setConfigs(configsList);
        new CaseFieldAdapter().createNewCaseField(caseField);
        TYPE_CASE_FIELD = caseField.getType();
        ITEMS_CASE_FIELD = caseField.getConfigs().get(0).getOptions().getItems();
    }

    @Then("Verify case field is created successfully via API")
    public void verifyCaseFieldIsCreatedSuccessfullyViaAPI() {
        Assert.assertEquals(TYPE_CASE_FIELD, "Multiselect");
        Assert.assertEquals(ITEMS_CASE_FIELD, "1, One\n2, Two");
    }
}