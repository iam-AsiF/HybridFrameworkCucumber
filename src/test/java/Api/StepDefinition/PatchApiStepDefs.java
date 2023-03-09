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
import Api.Repository.remoteRepo.requestRepo.UserPatchRequestModel;
import Api.Repository.remoteRepo.responseRepo.UserPatchApiResponseModel;

import static Api.Core.CoreConstrainHelper.base_url;
import static Api.Core.FilePathHelper.patchApiPath;

public class PatchApiStepDefs {
    String url;
    UserPatchRequestModel userPatchRequestModel;
    private String requestModel;
    private final Gson gson = new Gson();
    Response patchApiResponse;

    @Given("user got the base api {string}")
    public void userGotTheBaseApiPath(String path) {
        url = base_url + path;
    }

    @When("user hits patched {string}")
    public void userHitsPatchedJob(String job) {
        JSONObject requestBody = new FileHandleHelper().readJsonFile(patchApiPath);
        userPatchRequestModel = new Gson().fromJson(requestBody.toJSONString(), UserPatchRequestModel.class);
        userPatchRequestModel.getJob(job);
        requestModel = gson.toJson(userPatchRequestModel);
    }

    @And("calls the api with patched body")
    public void callsTheApiWithPatchedBody() {
        patchApiResponse = ApiCall.patchCall(HeaderFormatHelper.commonHeaders(), requestModel, url);
        System.out.println(patchApiResponse.body().asString());
    }

    @Then("it will return patched data")
    public void itWillReturnPatchedData() {
        UserPatchApiResponseModel userPatchApiResponseModel = gson.fromJson(patchApiResponse.getBody().asString(), UserPatchApiResponseModel.class);
        System.out.println(userPatchApiResponseModel.getUpdatedAt());
    }
}
