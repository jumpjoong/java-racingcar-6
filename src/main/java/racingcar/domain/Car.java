package racingcar.domain;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void move () {
        int randomNumber = new RandomNumber().randomNumber();

        if(randomNumber > 4) {
            position++;
        }
    }

    public String print () {
        return name + " : " + "-".repeat(position);
    }

    public String winCar() {
        return "최종 우승자 : " + name;
    }

    public int getPosition() {
        return position;
    }
}
