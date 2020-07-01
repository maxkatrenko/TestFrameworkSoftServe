package org.academy.demo4.myrepo;

import java.util.Base64;

public class test {
    public static void main(String[] args) {

        String username = "bestintheworldqq@gmail.com";
        String password = "Csnorarcemax1";

        String user = Base64.getEncoder().encodeToString(username.getBytes());
        String pass = Base64.getEncoder().encodeToString(password.getBytes());

        System.out.println(user);
        System.out.println(pass);
    }
}
