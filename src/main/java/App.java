import daos.CourseDAO;
import models.Course;
import models.CourseBuilder;

import java.util.InputMismatchException;

public class App {

    private CourseDAO courseDAO;

    public App() {
        courseDAO = new CourseDAO();
    }

    public void createCourse(String name, String city, String state, int yearEstablished,
                             int length, String elevation, String foliage, String teeType) {
        Course course = new CourseBuilder()
                .setName(name)
                .setCity(city)
                .setState(state)
                .setYearEstablished(yearEstablished)
                .setLength(length)
                .setElevation(elevation)
                .setFoliage(foliage)
                .setTeeType(teeType)
                .createCourse();
        courseDAO.create(course);
    }

    public void findCourseById(int id) {
        System.out.println(courseDAO.findById(id).toString());
    }

    public void findAll() {
        for (Course course : courseDAO.findAll()) {
            System.out.println(course.toString());
        }
    }

    public void updateStringVar(String name, String columnName, String newStringVar) {
        Course course = findCourseByName(name);
        switch (columnName) {
            case "name":
                course.setName(newStringVar);
                break;
            case "city":
                course.setCity(newStringVar);
                break;
            case "state":
                course.setState(newStringVar);
                break;
            case "elevation":
                course.setElevation(newStringVar);
                break;
            case "foliage":
                course.setFoliage(newStringVar);
                break;
            case "tee_type":
                course.setTeeType(newStringVar);
                break;
                default:
                    throw new InputMismatchException("Specified column name is invalid.");
        }
        courseDAO.update(course);
    }

    public void updateIntegerVariable(String name, String columnName, int newIntValue) {
        Course course = findCourseByName(name);
        if (columnName.equals("year_established")) {
            course.setYearEstablished(newIntValue);
        } else if (columnName.equals("length_ft")) {
            course.setLength(newIntValue);
        } else {
            throw new InputMismatchException("Specified column name is invalid.");
        }
        courseDAO.update(course);
    }

    public Course findCourseByName(String courseName) {
        Course course = null;
        for (Course c: courseDAO.findAll()) {
            if (c.getName().equals(courseName)) {
                course = c;
            }
        }
        if (course == null) {
            throw new InputMismatchException("Specified course name is invalid.");
        }
        return course;
    }

    public void delete(int id) {
        courseDAO.delete(id);
    }

}
