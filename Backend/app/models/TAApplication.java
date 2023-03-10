package models;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class TAApplication extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String firstname;
    @Constraints.Required
    public String lastname;

    @Constraints.Required
    public String email;
    @Constraints.Required
    public String phone;

    @Constraints.Required
    public String degreePlan;
    @Constraints.Required
    public String degreeBegin;
    @Constraints.Required
    public String gradDate;

    @Constraints.Required
    public String coursesTaken;
    @Constraints.Required
    public String firstPreference;

    public String secondPreference;
    public String thirdPreference;
    public String nonPreference;

    public static Find<Long, TAApplication> find = new Find<Long, TAApplication>(){};

    public static TAApplication findByName(String name) {
        return TAApplication.find
                .where()
                .eq("firstname", name)
                .findUnique();
    }
}