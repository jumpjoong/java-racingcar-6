package racingcar.domain;

import static racingcar.config.ErrorMsg.*;
import static racingcar.config.RuleMsg.*;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputUserHandler {

    public List<Car> inputCarName() {
        System.out.println(START_MSG.getMsg());
        String input = Console.readLine();
        String[] carName = input.split(",");

        //객체 생성 전에 검증하기로 ㄱㄱ
        //.map을 돌려서 각 문자열에 대해 앞뒤 공백 제거 후 리스트로 변환
        List<String> carListNames = Arrays.stream(carName).map(String::trim).toList();

        validCarNameLength(carListNames);
        validEmptyName(carListNames);
        //위에 리스트를 .map으로 돌려서 Car객체를 생성하면서 List<Car> 로 변환 (이름은 람다식표현으로 name -> new Car(name)과 동일
        List<Car> carList = carListNames.stream().map(Car::new).toList();
        return carList;
    }

    private void validCarNameLength(List<String> carListNames) {
        int maxNameLength = 5;

        for (String car : carListNames) {
            if (car.length() > maxNameLength) {
                throw new IllegalArgumentException(OVER_LENGTH.getMsg());
            }

        }
    }

    private void validEmptyName(List<String> carList) {
        for (String car: carList) {
            if(car.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_KEYWORDS.getMsg());
            }
        }
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
