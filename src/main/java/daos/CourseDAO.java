package daos;

import models.Course;
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
    public Course findById(int id) throws SQLException {
        Course course = null;
        Connection connection = SqlUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(GET_ONE);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                course = new Course();
                course.setId(rs.getInt("id"));
                course.setName(rs.getString("name"));
                course.setCity(rs.getString("city"));
                course.setState(rs.getString("state"));
                course.setYearEstablished(rs.getInt("year_established"));
                course.setLength(rs.getInt("length_ft"));
                course.setElevation(rs.getString("elevation"));
                course.setFoliage(rs.getString("foliage"));
                course.setTeeType("tee_type");
            }
        } catch (SQLException e) {
            SqlUtil.printError(e);
        }
        connection.close();
        return course;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<Course>();
        Connection connection = SqlUtil.getConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement("Select * from courses");
            ResultSet rs = pstmt.executeQuery();
            
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
