package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.ModelCreateUserRest;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.LastResponseStatusCode;
import task.CreateUserRest;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static utils.Constant.VALUE;
import static utils.enums.RestService.BASE_URL;

public class StepDefinitionRestCreateUser {

    @Before
    public void prepareStage(){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("brandon").whoCan(CallAnApi.at(BASE_URL.toString()));
    }

    @When("You create an user")
    public void youCreateAnUser(List<ModelCreateUserRest> modelCreateUserRests) {
        theActorInTheSpotlight().attemptsTo(CreateUserRest.with(modelCreateUserRests));
    }

    @Then("I should see the user created")
    public void iShouldSeeTheUserCreated() {
        theActorInTheSpotlight().should(seeThat(LastResponseStatusCode.is(VALUE)));
    }
}
