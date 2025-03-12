package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputCarName {
    List<String> carList= new ArrayList<>();

    public ValidCar inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carName = input.split(",");

        for (String car : carName) {
            car = car.trim();
            if (!car.isEmpty()) {
                carList.add(car);
            }
        }
        return new ValidCar(carList);
    }
}
