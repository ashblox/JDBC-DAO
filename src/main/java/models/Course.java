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
        return this.name + " " + this.city + " " + this.state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                name.equals(course.name) &&
                city.equals(course.city) &&
                state.equals(course.state);
    }

}
