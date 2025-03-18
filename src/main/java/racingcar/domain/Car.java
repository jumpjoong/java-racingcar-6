package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move () {
        int randomNumber = new RandomNumber().randomNumber();
        int overMove = 4;

        if(randomNumber > overMove) {
            position++;
        }
    }

    public String carNamePrint () {
        return name + " : " + "-".repeat(position);
    }


    public String getName () {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
