package Api.StepDefinition;

import Api.Core.ApiCall;
import Api.Core.FileHandleHelper;
import Api.Core.HeaderFormatHelper;
import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import Api.Repository.remoteRepo.requestRepo.UserPutRequestModel;
import Api.Repository.remoteRepo.responseRepo.UserPutApiResponseModel;

import static Api.Core.CoreConstrainHelper.base_url;
import static Api.Core.FilePathHelper.putApiPath;

public class PutApiStepDefs {
    String url;

    UserPutRequestModel userPutRequestModel;

    private final Gson gson = new Gson();

    private String requestModel;

    Response putApiResponse;

    @Given("user got the api {string}")
    public void userGotTheApiPath(String path) {
        url = base_url + path;
    }

    @When("user hits {string}")
    public void userHitsJob(String job) {
        JSONObject requestBody = new FileHandleHelper().readJsonFile(putApiPath);
        userPutRequestModel = new Gson().fromJson(requestBody.toJSONString(), UserPutRequestModel.class);
        userPutRequestModel.getJob(job);
        requestModel = gson.toJson(userPutRequestModel);
    }

    @And("calls the api with changed body")
    public void callsTheApiWithChangedBody() {
        putApiResponse = ApiCall.putCall(HeaderFormatHelper.commonHeaders(), requestModel, url);
        System.out.println(putApiResponse.body().asString());
    }

    @Then("it will return updated data")
    public void itWillReturnUpdatedData() {
        UserPutApiResponseModel userPutApiResponseModel = gson.fromJson(putApiResponse.getBody().asString(), UserPutApiResponseModel.class);
        System.out.println(userPutApiResponseModel.getUpdatedAt());
    }
}
