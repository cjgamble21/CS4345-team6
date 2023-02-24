package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.typesafe.config.ConfigFactory;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.concurrent.CompletionStage;


public class User {
	
    private String requestURL = ConfigFactory.load().getString("backend.url");

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public CompletionStage<WSResponse> checkAuthorized() {
        WSClient ws = play.test.WSTestClient.newClient(9005);
        //add username password
        WSRequest request = ws.url(this.requestURL + "/login");
        ObjectNode res = Json.newObject();
        res.put("username", this.username);
        res.put("password",this.password);
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }



    public  CompletionStage<WSResponse> registerUser() {

        WSClient ws = play.test.WSTestClient.newClient(9005);
        // send this. user
        ObjectNode res = Json.newObject();
        res.put("username", this.username);
        res.put("password",this.password);

        System.out.println(username);
        System.out.println(password);

        WSRequest request = ws.url(this.requestURL + "/signup");
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }

}
