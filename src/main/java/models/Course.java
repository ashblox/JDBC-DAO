package models;

import daos.DTO;

import java.util.Objects;


public class Course implements DTO {

    private int id;
    private String name;
    private String city;
    private String state;
    private int yearEstablished;
    private int length;
    private String elevation;
    private String foliage;
    private String teeType;

    public Course(int id, String name, String city, String state, int yearEstablished, int length, String elevation, String foliage, String teeType) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.yearEstablished = yearEstablished;
        this.length = length;
        this.elevation = elevation;
        this.foliage = foliage;
        this.teeType = teeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getYearEstablished() {
        return yearEstablished;
    }

    public void setYearEstablished(int yearEstablished) {
        this.yearEstablished = yearEstablished;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getFoliage() {
        return foliage;
    }

    public void setFoliage(String foliage) {
        this.foliage = foliage;
    }

    public String getTeeType() {
        return teeType;
    }

    public void setTeeType(String teeType) {
        this.teeType = teeType;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", yearEstablished=" + yearEstablished +
                ", length=" + length +
                ", elevation='" + elevation + '\'' +
                ", foliage='" + foliage + '\'' +
                ", teeType='" + teeType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(name, course.name) &&
                Objects.equals(city, course.city) &&
                Objects.equals(state, course.state);
    }

}
