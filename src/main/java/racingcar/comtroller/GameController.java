package racingcar.comtroller;

import racingcar.domain.Car;
import racingcar.domain.InputUserHandler;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    InputUserHandler inputUserHandler = new InputUserHandler();
    List<Car> car = new ArrayList<>();

    public void run() {
        this.car = inputUserHandler.inputCarName();
        int tryCount = inputUserHandler.inputTryCount();
        race(tryCount);
    }

    private void race (int tryCount) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < tryCount; i++){ //시도할 횟수 만큼 반복
            System.out.println(car);
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
         //필터를 이용해서 차의 거리와 최대 거리와 같은 객체를 뽑아내고 .map을 통해 각 객체의 이름을 뽑아내고 문자열로 변환
        List<String> winnerCars = car.stream().filter(cars -> cars.getPosition() == maxInt).map(Car::getName).toList();
        // String.join을 이용하면 대괄호가 사라지고 구분자도 원하는 걸로 바뀜
        System.out.println("최종 우승자 : " + String.join( ", ", winnerCars));
    }
}
