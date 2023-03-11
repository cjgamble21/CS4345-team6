package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.User;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class UserController extends Controller {

    public Result authenticate() {

        System.out.println("In authenticate");
        JsonNode req = request().body().asJson();
        String username = req.get("username").asText();
        String password = req.get("password").asText();

        try {
            User user = User.findByName(username); // ( match where username and password both match )
            if(user!=null && username.equals(user.username) && password.equals(user.password)){
                return ok("true");
            }else{
                return ok("false");
            }
        }
        catch (Exception e) {
            return ok("false");
        }

    }


    /**
     * When a user register, check if the username is taken
     * save to database if valid
     * POST
     * @return success if valid, fail if already taken
     */
    public Result registerNew() {
        System.out.println("In register");
        JsonNode req = request().body().asJson();
        ObjectMapper mapper = new ObjectMapper();
        String username = req.get("username").asText();
        User u = User.findByName(username);
        ObjectNode result = null;
        if (u == null) {
            System.out.println("new user");
            result = Json.newObject();
            try {
                User user = mapper.treeToValue(req, User.class);
                user.save();
            } catch (Exception e) {
                System.out.println(e);
            }

            result.put("body", username);
        }
        return ok(result);
    }

    public Result getUserByName(String name) {
        try {
            User user = User.findByName(name);
            JsonNode jsonNode = Json.toJson(user);
            String result = jsonNode.toString();
            return ok(result);
        } catch (Exception e) {
            System.out.println("Exception in getUserByName: " + e.toString());
            return internalServerError(e.toString());
        }
    }
}
