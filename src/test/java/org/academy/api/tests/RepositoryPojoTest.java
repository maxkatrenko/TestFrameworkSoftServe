package org.academy.api.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.academy.TestConfigurations;
import org.academy.api.pojo.RepositoryPojo;
import org.academy.api.requests.RepositoryRequests;
import org.testng.annotations.Test;

public class RepositoryPojoTest {

    private RepositoryRequests repositoryRequests = new RepositoryRequests();
    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createRepository() throws JsonProcessingException {
        String repositoryName = "test";
        RepositoryPojo repositoryPojo = new RepositoryPojo(repositoryName, "test repository",
                "https://github.com/");

        String jsonBody = mapper.writeValueAsString(repositoryPojo);

        repositoryRequests.createRepository(TestConfigurations.getApiToken(), jsonBody, 201);
        repositoryRequests.deleteRepository(TestConfigurations.getApiToken(), repositoryName, 204);
    }
}
