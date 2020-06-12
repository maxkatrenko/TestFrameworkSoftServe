package org.academy.api.requests;

import org.academy.utils.api.methods.DeleteRequest;
import org.academy.utils.api.methods.GetRequests;
import org.academy.utils.api.methods.PostRequest;

public class AbstractRequests {
    GetRequests getRequests = new GetRequests();
    PostRequest postRequest = new PostRequest();
    DeleteRequest deleteRequest = new DeleteRequest();

}
