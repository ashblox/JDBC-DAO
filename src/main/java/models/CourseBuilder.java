package models;

public class CourseBuilder {
    private int id;
    private String name;
    private String city;
    private String state;
    private int yearEstablished;
    private int length;
    private String elevation;
    private String foliage;
    private String teeType;

    public CourseBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public CourseBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public CourseBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public CourseBuilder setState(String state) {
        this.state = state;
        return this;
    }

    public CourseBuilder setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
        return this;
    }

    public CourseBuilder setLength(int length) {
        this.length = length;
        return this;
    }

    public CourseBuilder setElevation(String elevation) {
        this.elevation = elevation;
        return this;
    }

    public CourseBuilder setFoliage(String foliage) {
        this.foliage = foliage;
        return this;
    }

    public CourseBuilder setTeeType(String teeType) {
        this.teeType = teeType;
        return this;
    }

    public Course createCourse() {
        return new Course(id, name, city, state, yearEstablished, length, elevation, foliage, teeType);
    }
}