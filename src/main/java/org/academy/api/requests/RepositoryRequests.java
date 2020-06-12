package org.academy.api.requests;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.academy.api.Resources;

@Slf4j
public class RepositoryRequests extends AbstractRequests {

    public void createRepository(String token, String body, int responseCode) {
        Response response = postRequest.withToken(token, body, responseCode, Resources.getNewRepo());
        log.info(response.asString());
    }

    public void deleteRepository(String token, String repName, int responseCode) {
        Response response = deleteRequest.withToken(token, responseCode, Resources.getRepoForDelete() + repName);
        log.info(response.asString());
    }
}
