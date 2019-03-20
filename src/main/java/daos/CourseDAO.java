package daos;

import models.Course;
import utils.SqlUtil;

import java.util.List;
import java.sql.*;

public class CourseDAO extends DAO<Course>{

    private static final String INSERT = "insert into courses (name, city, state, year_established, length_ft, elevation, foliage, tee_type)" +
            "values(?,?,?,?,?,?,?,?)";
    private static final String GET_ONE = "select * from courses where id = ?";
    private static final String UPDATE = "update courses set name = ?, city = ?, state = ?, year_established = ?, length_ft = ?, elevation = ?, " +
            "foliage = ?, tee_type = ?";
    private static final String DELETE = "delete from courses where id = ?";

    public CourseDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Course findById(int id) {
        Course course = null;
        try (PreparedStatement preparedStatement = SqlUtil.getConnection().prepareStatement(GET_ONE);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
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
            System.err.println(e.getMessage());
        }
        return course;
    }

    @Override
    public List<Course> findAll() {
        return null;
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
