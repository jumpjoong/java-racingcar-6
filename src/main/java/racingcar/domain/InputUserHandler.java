package racingcar.domain;

import static racingcar.config.ErrorMsg.*;
import static racingcar.config.RuleMsg.*;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputUserHandler {
    List<String> carList= new ArrayList<>();

    public ValidCar inputCarName() {
        System.out.println(START_MSG.getMsg());
        String input = Console.readLine();
        String[] carName = input.split(",");

        for (String car : carName) {
            car = car.trim();
            carList.add(car);
        }
        return new ValidCar(carList);
    }

    public int inputTryCount() {
        System.out.println(TRY_COUNT_MSG.getMsg());
        String input = Console.readLine().trim();
        String regex = "^[0-9]*$";

        if(input.matches(regex) && !input.isEmpty()) {
            return Integer.parseInt(input);
        } else {
            throw new IllegalArgumentException(FIND_STRING.getMsg());
        }
    }
}
