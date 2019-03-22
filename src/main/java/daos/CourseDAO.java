package daos;

import models.Course;
import models.CourseBuilder;
import utils.SqlUtil;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CourseDAO extends DAO<Course>{

    private static final String INSERT = "insert into courses (name, city, state, year_established, length_ft, elevation, foliage, tee_type)" +
            "values(?,?,?,?,?,?,?,?)";
    private static final String GET_ONE = "select * from courses where id = ?";
    private static final String UPDATE = "update courses set name = ?, city = ?, state = ?, year_established = ?, length_ft = ?, elevation = ?, " +
            "foliage = ?, tee_type = ?";
    private static final String DELETE = "delete from courses where id = ?";

    @Override
    public Course findById(int id) {
        Course course = null;
        try (Connection connection = SqlUtil.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement(GET_ONE);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                course = new CourseBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .setCity(rs.getString("city"))
                .setState(rs.getString("state"))
                .setYearEstablished(rs.getInt("year_established"))
                .setLength(rs.getInt("length_ft"))
                .setElevation(rs.getString("elevation"))
                .setFoliage(rs.getString("foliage"))
                .setTeeType(rs.getString("tee_type"))
                .createCourse();
            }
        } catch (SQLException e) {
            SqlUtil.printError(e);
        }
        return course;
    }

//    public Course createCourseFromResultSet(ResultSet rs) throws SQLException {
//        Course course = new Course();
//        while (rs.next()) {
//            course = new Course();
//            course.setId(rs.getInt("id"));
//            course.setName(rs.getString("name"));
//            course.setCity(rs.getString("city"));
//            course.setState(rs.getString("state"));
//            course.setYearEstablished(rs.getInt("year_established"));
//            course.setLength(rs.getInt("length_ft"));
//            course.setElevation(rs.getString("elevation"));
//            course.setFoliage(rs.getString("foliage"));
//            course.setTeeType("tee_type");
//        }
//        return course;
//    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = SqlUtil.getConnection()){
            PreparedStatement pstmt = connection.prepareStatement("Select * from courses");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) { // shifts the resultset cursor down to next record
                // fetches current record
                Course currentCourse = new CourseBuilder()
                .setId(rs.getInt("id"))
                .setName(rs.getString("name"))
                .setCity(rs.getString("city"))
                .setState(rs.getString("state"))
                .setYearEstablished(rs.getInt("year_established"))
                .setLength(rs.getInt("length_ft"))
                .setElevation(rs.getString("elevation"))
                .setFoliage(rs.getString("foliage"))
                .setTeeType("tee_type")
                .createCourse();

                // adds current record
                courses.add(currentCourse);
            }
        } catch (SQLException e) {
            SqlUtil.printError(e);
        }
        return courses;
    }

    @Override
    public Course update(Course dto) {
        return null;
    }

    @Override
    public Course create(Course dto) {
        return null;
    }

    @Override
    public void delete(int i) {

    }
}
