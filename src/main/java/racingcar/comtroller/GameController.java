package racingcar.comtroller;

import racingcar.domain.Car;
import racingcar.domain.InputUserHandler;
import racingcar.domain.ValidCar;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    InputUserHandler inputUserHandler = new InputUserHandler();
    List<Car> car = new ArrayList<>();

    int test;

    public void run() {
        ValidCar carName = inputUserHandler.inputCarName();
        for (String name : carName.getCarList()) {
            car.add(new Car(name));
        }
        this.test = inputUserHandler.inputTryCount();
        race();
    }

    public void race () {
        System.out.println("\n실행 결과");
        for (int i = 0; i < test; i++){ //시도할 횟수 만큼 반복
            for (Car cars: car){ //자동차 입력 갯수 만큼 반복
                cars.move();
            }
            printRaceResults();
        }
    }
    private void printRaceResults() {
        for (Car cars : car) { //자동차 개수 만큼 출력
            System.out.println(cars.print());
        }
        System.out.println();
        isWinPrint();
    }
    private void isWinPrint () { //
        for (Car cars : car) {
            if(test == cars.getPosition()) {
                System.out.println(cars.winCar());
            }
        }
    }
}
