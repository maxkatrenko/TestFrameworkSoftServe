package org.academy.api.requests;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.academy.api.Resources;

@Slf4j
public class IssueRequests extends AbstractRequests {

    public void createIssue(String body, int responseCode) {
        Response response = postRequest.withoutToken(body, responseCode, Resources.getNewIssue());
        log.info(response.asString());
    }
}
