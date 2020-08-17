package org.academy.web.tests.ci.api;

import org.academy.api.requests.PullRequestRequests;
import org.academy.utils.GetRealSSHKKeyForGit;
import org.testng.annotations.Test;

public class PullRequestTests {
    private PullRequestRequests pullRequestRequests = new PullRequestRequests();

    @Test
    public void getAllPullRequests() {
        pullRequestRequests.getAllPRRequest(GetRealSSHKKeyForGit.getDecodedKey(), 200);
    }
}
