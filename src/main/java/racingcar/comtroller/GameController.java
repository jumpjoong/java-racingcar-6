package racingcar.comtroller;

import racingcar.domain.Car;
import racingcar.domain.InputUserHandler;
import racingcar.domain.ValidCar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameController {
    InputUserHandler inputUserHandler = new InputUserHandler();
    List<Car> car = new ArrayList<>();

    public void run() {
        ValidCar carName = inputUserHandler.inputCarName();
        for (String name : carName.getCarList()) {
            car.add(new Car(name));
        }
        int tryCount = inputUserHandler.inputTryCount();
        race(tryCount);
    }

    public void race (int tryCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++){ //시도할 횟수 만큼 반복
            for (Car cars: car){ //자동차 갯수 만큼 반복
                cars.move();
            }
            printRaceResults();
        }
        maxPosition();
    }

    private void printRaceResults() {
        for (Car cars : car) { //자동차 개수 만큼 출력
            System.out.println(cars.carNamePrint());
        }
        System.out.println();
    }

    private void maxPosition() {
        int maxInt = 0;
        for (Car cars : car) {
            if(maxInt < cars.getPosition()) {
                maxInt = cars.getPosition();
            }
        }
        isWinPrint(maxInt);
    }

    private void isWinPrint (int maxInt) { //
        for (Car cars : car) {
            if(maxInt == cars.getPosition()) {
                System.out.println(cars.winCar());
            }
        }
    }
}
