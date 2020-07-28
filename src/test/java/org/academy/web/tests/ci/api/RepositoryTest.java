package org.academy.web.tests.ci.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.academy.api.pojo.RepositoryPojo;
import org.academy.api.requests.RepositoryRequests;
import org.academy.utils.GetRealSSHKKeyForGit;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Base64;

public class RepositoryTest {

    private final RepositoryRequests repositoryRequests = new RepositoryRequests();
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void createRepositoryTest() {
        String repositoryName = "test_repository";

        RepositoryPojo repositoryPojo = new RepositoryPojo(repositoryName, "test repository");

        String jsonBody = null;
        try {
            jsonBody = mapper.writeValueAsString(repositoryPojo);
        } catch (JsonProcessingException e) {
            Assert.fail();
        }

        repositoryRequests.createRepository(GetRealSSHKKeyForGit.getDecodedKey(), jsonBody, 201);
        repositoryRequests.deleteRepository(GetRealSSHKKeyForGit.getDecodedKey(), repositoryName, 204);
    }
}
