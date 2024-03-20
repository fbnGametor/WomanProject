package model.entities;

import model.enums.HairColor;
import model.enums.EyeColor;

public class Woman {

    private String name;
    private int age;
    private int height;
    private double weight;
    private int hairLength;
    private HairColor hairColor;
    private EyeColor eyeColor;
    private int hotness;
    private int points = 0;

    public Woman(String name, int age, int height, double weight, int hairLength, HairColor hairColor, EyeColor eyeColor, int hotness) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.hairLength = hairLength;
        this.hairColor = hairColor;
        this.eyeColor = eyeColor;
        this.hotness = hotness;
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

    public int getHotness() {
        return hotness;
    }

    public void setHotness(int hotness) {
        this.hotness = hotness;
    }

    private void setPoints() {

        if (age < 14) {
            points += 0;
        } else if (age <= 16) {
            points += 3;
        } else if (age <= 25) {
            points += 20;
        } else if (age <= 35) {
            points += 15;
        } else if (age <= 55) {
            points += 3;
        } else if (age <= 75) {
            points += 0;
        } else {
            points += 0;
        }

        if (height < 134) {
            points += 0;
        } else if (height <= 140) {
            points += 3;
        } else if (height <= 150) {
            points += 10;
        } else if (height <= 165) {
            points += 20;
        } else if (height <= 170) {
            points += 10;
        } else if (height <= 175) {
            points += 5;
        } else if (height <= 185) {
            points += 2;
        } else {
            points += 0;
        }

        if (weight <= 35.0) {
            points += 3;
        } else if (weight > 35 && weight <= 45.0) {
            points += 8;
        } else if (weight > 45 && weight <= 55.0) {
            if (height > 160) {
                points += 2;
            } else {
                points += 20;
            }
        } else if (weight > 55 && weight <= 65) {
            if (height > 170) {
                points += 12;
            } else {
                points += 4;
            }
        } else if (weight > 65 && weight <= 75) {
            if (height > 184) {
                points += 8;
            } else {
                points += 1;
            }
        } else if (weight > 75 && weight <= 85) {
            points += 1;
        } else {
            points += 0;
        }

        if (hairLength == 1) {
            points += 0;
        } else if (hairLength == 2) {
            points += 5;
        } else if (hairLength == 3) {
            points += 8;
        } else if (hairLength == 4) {
            points += 10;
        } else if (hairLength == 5) {
            points += 10;
        } else if (hairLength == 6) {
            points += 8;
        }
        if (hairColor.toString() == "FELIPE_NETO") {
            points += 0;
        } else if (hairColor.toString() == "GREEN" || hairColor.toString() == "BLUE") {
            points += 5;
        } else {
            points += 10;
        }

        if (hotness == 1) {
            points += 0;
        } else if (hotness == 2) {
            points += 3;
        } else if (hotness == 3) {
            points += 8;
        } else if (hotness == 4) {
            points += 3;
        } else if (hotness == 5) {
            points += 10;
        } else if (hotness == 6) {
            points += 18;
        } else if (hotness == 7) {
            points += 20;
        }
    }

    public int getPoints() {
        setPoints();
        return points;
    }
}
