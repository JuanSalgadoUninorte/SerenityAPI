package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import questions.LastResponseStatus;
import task.AddNumbers;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitionsSoapAddNumbers {

    @When("you add two numbers")
    public void youAddTwoNumbers(List<String>values) {
        theActorInTheSpotlight().attemptsTo(AddNumbers.with(values));
    }

    @Then("I should see the response of the service is {int}")
    public void iShouldSeeTheResponseOfTheServiceIs(Integer int1) {
        int code = 0;
        theActorInTheSpotlight().should(
                seeThat("last response status code is 200",
                LastResponseStatus.isEqualsTo(code))
        );
    }


}
