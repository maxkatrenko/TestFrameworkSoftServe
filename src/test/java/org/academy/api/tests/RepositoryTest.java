package org.academy.api.tests;

import org.academy.TestConfigurations;
import org.academy.api.requests.RepositoryRequests;
import org.testng.annotations.Test;

public class RepositoryTest {

    private RepositoryRequests repositoryRequests = new RepositoryRequests();

    @Test
    public void createTestRepository() {
        String jsonBody = "{\n" +
                "  \"name\": \"test\",\n" +
                "  \"description\": \"test repository\",\n" +
                "  \"homepage\": \"https://github.com\",\n" +
                "  \"private\": false\n" +
                "}";
        repositoryRequests.createRepository(TestConfigurations.getApiToken(), jsonBody, 201);
    }

    @Test
    public void deleteTestRepository() {
        String repName = "test";
        repositoryRequests.deleteRepository(TestConfigurations.getApiToken(), repName, 204);
    }
}
