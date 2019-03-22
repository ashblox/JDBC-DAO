package daos;

import models.Course;
import models.CourseBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseDAOTest {

    @Test
    public void findByIdTest() throws SQLException {
        CourseDAO courseDAO = new CourseDAO();
        Course expected = new CourseBuilder().createCourse();
        expected.setId(1);
        expected.setName("White Clay");
        expected.setCity("Newark");
        expected.setState("Delaware");

        Course actual = courseDAO.findById(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createCoursesTest() {
        CourseDAO courseDAO = new CourseDAO();
        List<Course> expected = new ArrayList<Course>();
        expected.add(new CourseBuilder().setId(1).setName("White Clay").setCity("Newark").setState("Delaware").createCourse());
        expected.add(new CourseBuilder().setId(2).setName("Greenridge").setCity("Newark").setState("Delaware").createCourse());
        expected.add(new CourseBuilder().setId(3).setName("Iron Hill").setCity("Newark").setState("Delaware").createCourse());
        expected.add(new CourseBuilder().setId(4).setName("Brandywine").setCity("Wilmington").setState("Delaware").createCourse());
        expected.add(new CourseBuilder().setId(5).setName("Bellevue").setCity("Wilmington").setState("Delaware").createCourse());
        expected.add(new CourseBuilder().setId(6).setName("Anson B. Nixon").setCity("Kennett Square").setState("Pennsylvania").createCourse());
        expected.add(new CourseBuilder().setId(7).setName("Lums Pond").setCity("Newark").setState("Delaware").createCourse());

        List<Course> actual = courseDAO.findAll();

        for (Course course : expected) {
            Assert.assertTrue(actual.contains(course));
        }
    }
}
