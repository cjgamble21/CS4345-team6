package models;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class User extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String username;
    @Constraints.Required
    public String password;

    // Name / Title
    @Constraints.Required
    public String title;
    @Constraints.Required
    public String firstname;
    @Constraints.Required
    public String lastname;

    // Email / Phone / Fax
    @Constraints.Required
    public String email;
    @Constraints.Required
    public String phone;

    public String fax;

    // Address
    @Constraints.Required
    public String address;

    // City / State / Zip
    @Constraints.Required
    public String city;
    @Constraints.Required
    public String state;
    @Constraints.Required
    public int zip;

    // Research Areas
    public String researchAreas;
    public String position;
    public String affiliation;

    // Status
    @Constraints.Required
    public String status;

    public String degreePlan;
    public String degreeBegin;
    public String gradDate;

    // Comments
    public String comments;

    public static Find<Long, User> find = new Find<Long, User>(){};

    public static User findByName(String name) {
        return User.find
                .where()
                .eq("username", name)
                .findUnique();
    }
}
