package org.academy.api;

import org.academy.PropertyReader;

public class Resources {
    private static String read(String value) {
        return PropertyReader.get().readValue(value);
    }

    public static String getPullRequests() {
        return read("pull_requests");
    }

    public static String getNewRepo() {
        return read("new_repo");
    }

    public static String getRepoForDelete() {
        return read("repo_for_delete");
    }
}
