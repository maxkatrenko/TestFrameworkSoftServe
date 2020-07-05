package org.academy.api.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.academy.TestConfigurations;
import org.academy.api.pojo.RepositoryPojo;
import org.academy.api.requests.RepositoryRequests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;


public class RepositoryTest {

    private final RepositoryRequests repositoryRequests = new RepositoryRequests();
    private final ObjectMapper mapper = new ObjectMapper();
    byte[] decodedToken = Base64.getDecoder().decode(TestConfigurations.getEncodedApiToken());

    @Test(groups = "my_tests")
    public void createRepositoryTest() {
        String repositoryName = "test";

        RepositoryPojo repositoryPojo = new RepositoryPojo(repositoryName, "test repository");

        String jsonBody = null;
        try {
            jsonBody = mapper.writeValueAsString(repositoryPojo);
        } catch (JsonProcessingException e) {
            Assert.fail();
        }

        repositoryRequests.createRepository(new String(decodedToken), jsonBody, 201);
        repositoryRequests.deleteRepository(new String(decodedToken), repositoryName, 204);
    }
}
