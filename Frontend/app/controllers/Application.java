package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.typesafe.config.ConfigFactory;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.concurrent.CompletionStage;

public class Application {
    
    private String requestURL = ConfigFactory.load().getString("backend.url");

    private String firstname;
    private String lastname;
    
    private String email;
    private String phone;

    private String degreePlan;
    private String degreeBegin;
    private String gradDate;

    private String coursesTaken;
    private String firstPreference;
    private String secondPreference;
    private String thirdPreference;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDegreePlan() {
        return degreePlan;
    }

    public void setDegreePlan(String degreePlan) {
        this.degreePlan = degreePlan;
    }

    public String getDegreeBegin() {
        return degreeBegin;
    }

    public void setDegreeBegin(String degreeBegin) {
        this.degreeBegin = degreeBegin;
    }

    public String getGradDate() {
        return gradDate;
    }

    public void setGradDate(String gradDate) {
        this.gradDate = gradDate;
    }

    public String getCoursesTaken() {
        return coursesTaken;
    }

    public void setCoursesTaken(String coursesTaken) {
        this.coursesTaken = coursesTaken;
    }

    public String getFirstPreference() {
        return firstPreference;
    }

    public void setFirstPreference(String firstPreference) {
        this.firstPreference = firstPreference;
    }

    public String getSecondPreference() {
        return secondPreference;
    }

    public void setSecondPreference(String secondPreference) {
        this.secondPreference = secondPreference;
    }

    public String getThirdPreference() {
        return thirdPreference;
    }

    public void setThirdPreference(String thirdPreference) {
        this.thirdPreference = thirdPreference;
    }

    public CompletionStage<Application> submitApplication() {
        WSClient ws = play.test.WSTestClient.newClient(9005);
        
        ObjectNode res = Json.newObject();
        res.put("firstname", this.firstname);
        res.put("lastname", this.lastname);
        res.put("email", this.email);
        res.put("phone", this.phone);
        res.put("degreePlan", this.degreePlan);
        res.put("degreeBegin", this.degreeBegin);
        res.put("gradDate", this.gradDate);
        res.put("coursesTaken", this.coursesTaken);
        res.put("firstPreference", this.firstPreference);

        if (!empty(this.secondPreference))
            res.put("secondPreference", this.secondPreference);

        if (!empty(this.thirdPreference))
            res.put("thirdPreference", this.thirdPreference);

    }

    private static boolean empty(String field) {
        return field.equals("");
    }
}
