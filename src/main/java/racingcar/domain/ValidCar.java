package racingcar.domain;

import java.util.List;

public class ValidCar {
    private final List<String> carNumber;

    ValidCar(List<String> carNumber) {
        this.carNumber = carNumber;
    }
    //이름 5자 이하 검증 로직
}
