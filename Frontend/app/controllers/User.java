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

    // Account info
    private String username;
    private String password;
    private String confirmPassword;

    // Name & title
    private String title;
    private String firstname;
    private String lastname;

    // Email / Phone
    private String email;
    private String phone;
    private String fax;

    // Address
    private String address;

    // City/State/Zip
    private String city;
    private String state;
    private int zip;

    // Research Area
    private String researchAreas;

    // Positon/Affiliation
    private String position;
    private String affiliation;

    // Status
    private String status;

    // If student:
    private String degreePlan;
    private String degreeBegin;
    private String gradDate;

    // Comments
    private String comments;

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

    public String getConfirmPassword() { return confirmPassword; }

    public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getResearchAreas() {
        return researchAreas;
    }

    public void setResearchAreas(String researchAreas) {
        this.researchAreas = researchAreas;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public CompletionStage<WSResponse> checkAuthorized() {
        WSClient ws = play.test.WSTestClient.newClient(9005);
        //add username password
        WSRequest request = ws.url(this.requestURL + "/login");
        ObjectNode res = Json.newObject();
        res.put("username", this.username);
        res.put("password", this.password);
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }


    public CompletionStage<WSResponse> registerUser() {

        WSClient ws = play.test.WSTestClient.newClient(9005);
        // send this user
        ObjectNode res = Json.newObject();
        res.put("username", this.username);
        res.put("password", this.password);
        res.put("title", this.title);
        res.put("firstname", this.firstname);
        res.put("lastname", this.lastname);
        res.put("email", this.email);
        res.put("phone", this.phone);
        if (!empty(this.fax))
            res.put("fax", this.fax);
        res.put("address", this.address);
        res.put("city", this.city);
        res.put("state", this.state);
        res.put("zip", this.zip);
        if (!empty(this.researchAreas))
            res.put("researchAreas", this.researchAreas);
        if (!empty(this.position))
            res.put("position", this.position);
        if (!empty(this.affiliation))
            res.put("affiliation", this.affiliation);
        res.put("status", this.status);
        if (student(this.status)) {
            res.put("degreePlan", this.degreePlan);
            res.put("degreeBegin", this.degreeBegin);
            res.put("gradDate", this.gradDate);
        }
        if (!empty(this.comments))
            res.put("comments", this.comments);

        System.out.println(this.username);
        System.out.println(this.password);

        WSRequest request = ws.url(this.requestURL + "/signup");
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }

    // Helper Methods
    private static boolean empty(String field) {
        return field == "";
    }

    private static boolean student(String status) {
        return status == "Student";
    }

}
