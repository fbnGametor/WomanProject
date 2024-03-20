package model.entities;

import model.enums.HairColor;
import model.enums.EyeColor;

public class Man extends Person{

    private int body;


    public Man(String name, int age, int height, double weight, int hairLength, HairColor hairColor, EyeColor eyeColor, int body) {
        super(name, age, height, weight, hairLength, hairColor, eyeColor);
        this.body = body;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    @Override
    void setPoints() {

    }

    @Override
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
