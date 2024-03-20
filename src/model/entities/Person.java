package model.entities;

import model.enums.EyeColor;
import model.enums.HairColor;

abstract public class Person {

    protected String name;
    protected int age;
    protected int height;
    protected double weight;
    protected int hairLength;
    protected HairColor hairColor;
    protected EyeColor eyeColor;

    protected int points;

    public Person(String name, int age, int height, double weight, int hairLength, HairColor hairColor, EyeColor eyeColor) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.hairLength = hairLength;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getHairLength() {
        return hairLength;
    }

    public void setHairLength(int hairLength) {
        this.hairLength = hairLength;
    }

    public String getHairColor() {
        return hairColor.toString();
    }

    public void setHairColor(HairColor hairColor) {
        this.hairColor = hairColor;
    }

    public String getEyeColor() {
        return eyeColor.toString();
    }

    public void setEyeColor(EyeColor eyeColor) {
        this.eyeColor = eyeColor;
    }

    abstract void setPoints();

    public int getPoints() {
        setPoints();
        if(points < 0) {
            return 0;
        } else if(points > 100) {
            return 100;
        } else {
            return points;
        }

    }

}
