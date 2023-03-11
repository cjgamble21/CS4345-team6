package models;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Model;
import play.data.validation.Constraints;
import models.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @ManyToOne
    public User user;

    public String name;

    public static Find<Long, Course> find = new Find<Long, Course>(){};
}