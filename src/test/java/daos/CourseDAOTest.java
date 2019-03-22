package daos;

import models.Course;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

public class CourseDAOTest {

    @Test
    public void findByIdTest() throws SQLException {
        CourseDAO courseDAO = new CourseDAO();
        Course expected = new Course();
        expected.setId(1);
        expected.setName("White Clay");
        expected.setCity("Newark");
        expected.setState("Delaware");

        Course actual = courseDAO.findById(1);

        Assert.assertEquals(expected, actual);
    }
}
