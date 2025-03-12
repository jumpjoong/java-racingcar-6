package racingcar.domain;

import java.util.List;

public class ValidCar {
    private final List<String> carList;

    ValidCar(List<String> carList) {
        test(carList);
        this.carList = carList;
    }

    private void test (List<String> carList) {
        if(!validCarNameLength(carList)) {
            throw new IllegalArgumentException("5글자 초과");
        }
    }

    //이름 5자 이하 검증 로직
    private boolean validCarNameLength(List<String> carList) {
        for (String car : carList) {
            if (car.length() > 5) {
                return false;
            }
        }
        return true;
    }
}
