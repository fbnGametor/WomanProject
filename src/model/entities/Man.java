package model.entities;

import model.enums.HairColor;
import model.enums.EyeColor;

public class Man extends Person{

    private int body;
    private double balance;
    private int problem;

    public Man(String name, int age, int height, double weight, int hairLength, HairColor hairColor, EyeColor eyeColor, int body, double balance, int problem) {
        super(name, age, height, weight, hairLength, hairColor, eyeColor);
        this.body = body;
        this.balance = balance;
        this.problem = problem;
    }

    public int getBody() {
        return body;
    }

    public void setBody(int body) {
        this.body = body;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getProblem() {
        return problem;
    }

    public void setProblem(int problem) {
        this.problem = problem;
    }

    @Override
    void setPoints() {

        points = 0;

        if (age < 14) {
            points += 0;
        } else if (age <= 16) {
            points += 3;
        } else if (age <= 25) {
            points += 10;
        } else if (age <= 35) {
            points += 7;
        } else if (age <= 55) {
            points += 3;
        } else if (age <= 75) {
            points += 0;
        } else {
            points += 0;
        }

        if (height < 150) {
            points += 0;
        } else if (height <= 160) {
            points += 2;
        } else if (height <= 170) {
            points += 5;
        } else if (height <= 180) {
            points += 18;
        } else if (height <= 185) {
            points += 20;
        } else if (height <= 190) {
            points += 18;
        } else if (height <= 200) {
            points += 6;
        } else {
            points += 0;
        }

        if (weight <= 50.0) {
            points += 0;
        } else if (weight > 50 && weight <= 60.0) {
            if(height < 171) {
                points += 15;
            } else {
                points += 5;
            }
        } else if (weight > 60 && weight <= 70.0) {
            if(height > 170 && height < 180) {
                points += 20;
            } else {
                points += 5;
            }
        } else if (weight > 70 && weight <= 85) {
            if(height > 185) {
                points += 20;
            } else if(height < 185 && height > 178){
                points += 12;
            } else {
                points += 8;
            }
        } else if (weight > 85 && weight <= 95) {
            if(height > 188) {
                points += 18;
            } else if(height < 188 && height > 177){
                points += 9;
            } else {
                points += 1;
            }
        } else if (weight > 95 && weight <= 120) {
            if(height > 190) {
                points += 16;
            } else if(height < 190 && height > 180) {
                points += 4;
            } else {
                points += 1;
            }
        } else if(weight > 120 && weight < 150){
            points += 1;
        } else {
            points += 0;
        }

        switch(hairLength) {
            case 1:
                points += 1;
                break;
            case 2:
                // Se for leve ou gordo com 176
                if(weight < 80) {
                    if(height <= 176) {
                        points += 10;
                    }
                } else {
                    if(height < 176) {
                        points += 1;
                    }
                }
                if(height > 176) {
                    if(weight > 120) {
                        points += 1;
                    } else {
                        points += 10;
                    }
                }
                break;
            case 3:
                points += 7;
                break;
            case 4:
                points += 13;
                break;
            case 5:
                points += 20;
                break;
            case 6:
                points += 15;
                break;
            case 7:
                points += 8;
                break;
            case 8:
                //placeholder
                if(weight > 100 && height > 180) {
                    points += 16;
                } else {
                    points += 10;
                }
                break;
            case 9:
                points += 18;
                break;
            case 10:
                points += 9;
                break;
            case 11:
                points += 0;
                break;
            case 12:
                points += 4;
                break;
        }

        switch(body) {
            case 1:
                points += 0;
                break;
            case 2:
                points += 6;
                break;
            case 3:
                points += 12;
                break;
            case 4:
                points += 2;
                break;
            case 5:
                points += 7;
                break;
            case 6:
                points += 12;
                break;
            case 7:
                points += 16;
                break;
            case 8:
                points += 20;
                break;
            case 9:
                points += 3;
                break;
            case 10:
                points += 5;
                break;
        }

        if(balance < 200) {
            points += 0;
        } else if(balance >= 200 && balance <= 1200) {
            points += 2;
        } else if(balance > 1200 && balance >= 3000) {
            points += 5;
        } else if(balance > 3000 && balance >= 5500) {
            points += 8;
        } else if(balance > 5500) {
            points += 10;
        }

        switch(problem) {
            case 1:
                points += 0;
                break;
            case 2:
                points -= 25;
                break;
            case 3:
                points -= 40;
                break;
            case 4:
                points -= 20;
                break;
            case 5:
                points -= 50;
                break;
            case 6:
                points -= 40;
                break;
        }

    }

    @Override
    public int getPoints() {
        setPoints();
        if(points < 0) {
            return 0;
        } else {
            return points;
        }

    }
}
