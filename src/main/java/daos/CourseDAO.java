package daos;

import models.Course;
import models.CourseBuilder;
import utils.SqlUtil;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CourseDAO extends DAO<Course> {

    private static final String INSERT = "insert into courses (name, city, state, year_established, length_ft, elevation, foliage, tee_type)" +
            "values(?,?,?,?,?,?,?,?)";
    private static final String GET_ONE = "select * from courses where id = ?";
    private static final String UPDATE = "update courses set name = ?, city = ?, state = ?, year_established = ?, length_ft = ?, elevation = ?, " +
            "foliage = ?, tee_type = ? where id = ?";
    private static final String DELETE = "delete from courses where id = ?";

    @Override
    public Course findById(int id) {
        Course course = null;
        try (Connection connection = SqlUtil.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(GET_ONE);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            course = createCourseFromResultSet(rs);
        } catch (SQLException e) {
            SqlUtil.printError(e);
        }
        return course;
    }

    public Course createCourseFromResultSet(ResultSet rs) throws SQLException {
        Course course = null;
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
        return course;
    }

    @Override
    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        try (Connection connection = SqlUtil.getConnection()) {
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
                        .setTeeType(rs.getString("tee_type"))
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
        Course course = null;
        try (Connection connection = SqlUtil.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(UPDATE);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getCity());
            pstmt.setString(3, dto.getState());
            pstmt.setInt(4, dto.getYearEstablished());
            pstmt.setInt(5, dto.getLength());
            pstmt.setString(6, dto.getElevation());
            pstmt.setString(7, dto.getFoliage());
            pstmt.setString(8, dto.getTeeType());
            pstmt.setInt(9, dto.getId());
            pstmt.executeUpdate();
            course = findById(dto.getId());
        } catch (SQLException e) {
            SqlUtil.printError(e);
        }
        return course;
    }

    @Override
    public Course create(Course dto) {
        Course course = null;
        try (Connection connection = SqlUtil.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, dto.getName());
            pstmt.setString(2, dto.getCity());
            pstmt.setString(3, dto.getState());
            pstmt.setInt(4, dto.getYearEstablished());
            pstmt.setInt(5, dto.getLength());
            pstmt.setString(6, dto.getElevation());
            pstmt.setString(7, dto.getFoliage());
            pstmt.setString(8, dto.getTeeType());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            int id = -1;
            if (rs.next()) {
                id = rs.getInt(1);
            }
            course = findById(id);
        } catch (SQLException e) {
            SqlUtil.printError(e);
        }
        return course;
    }

    @Override
    public void delete(int id) {
        try (Connection connection = SqlUtil.getConnection()) {
            PreparedStatement pstmt = connection.prepareStatement(DELETE);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            SqlUtil.printError(e);
        }
    }
}
