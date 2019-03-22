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
        Course expected = new CourseBuilder()
                .setId(1)
                .setName("White Clay")
                .setCity("Newark")
                .setState("Delaware")
                .createCourse();

        Course actual = courseDAO.findById(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAllTest() {
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

    @Test
    public void updateCourseTest() {
        CourseDAO courseDAO = new CourseDAO();
        Course toUpdate = new CourseBuilder()
                .setId(3).setName("Iron Hill")
                .setCity("Newark")
                .setState("Delaware")
                .setYearEstablished(2008)
                .setLength(10045)
                .setElevation("medium ski hill")
                .setFoliage("dense") // changing from 'pinball' to 'dense'
                .setTeeType("concrete")
                .createCourse();

        Course updated = courseDAO.update(toUpdate);
        System.out.println(courseDAO.findAll());
        Assert.assertEquals(toUpdate.getFoliage(), updated.getFoliage());
    }

    @Test
    public void createCourseTest() {
        CourseDAO courseDAO = new CourseDAO();
        Course expected = new CourseBuilder()
                .setName("Canby West")
                .setCity("Wilmington")
                .setState("Delaware")
                .setYearEstablished(2011)
                .setLength(5666)
                .setElevation("50/50 flat/hills")
                .setFoliage("mixed - trees/open")
                .setTeeType("natural")
                .createCourse();

        Course actual = courseDAO.create(expected);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteTest() {
        CourseDAO courseDAO = new CourseDAO();
        List<Course> beforeDelete = courseDAO.findAll();
        Course toAddAndDelete = new CourseBuilder()
                .setName("Canby West")
                .setCity("Wilmington")
                .setState("Delaware")
                .setYearEstablished(2011)
                .setLength(5666)
                .setElevation("50/50 flat/hills")
                .setFoliage("mixed - trees/open")
                .setTeeType("natural")
                .createCourse();
        Course added = courseDAO.create(toAddAndDelete);
        int idToDelete = added.getId();

        courseDAO.delete(idToDelete);

        List<Course> afterDelete = courseDAO.findAll();
        Assert.assertFalse(afterDelete.contains(toAddAndDelete));
    }
}
