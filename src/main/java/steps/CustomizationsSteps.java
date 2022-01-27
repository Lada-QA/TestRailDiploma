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
import java.util.Random;

public class CustomizationsSteps {
    public static String TYPE_CASE_FIELD;
    public static String ITEMS_CASE_FIELD;

    @When("User send POST request for add new case field with Random name")
    public void userSendPostRequestForAddNewCaseField() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();
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
                .name(generatedString)
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