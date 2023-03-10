package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.TAApplication;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class TAApplicationController extends Controller {
    public Result saveApplication() {
        JsonNode req = request().body().asJson();
        String firstname = req.get("firstname").asText();
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode result = Json.newObject();

        try {
            TAApplication application = mapper.treeToValue(req, TAApplication.class);
            application.save();
        } catch (Exception e) {
            System.out.println(e);
        }

        result.put("body", firstname);

        return ok(result);
    }
}