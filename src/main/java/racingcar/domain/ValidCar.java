package racingcar.domain;

import java.util.List;

import static  racingcar.config.ErrorMsg.*;

public class ValidCar {
    private final List<String> carList;

    ValidCar(List<String> carList) {
        test(carList);
        this.carList = carList;
    }

    //변수 초기화 전 에러 던지기
    private void test (List<String> carList) {
        if(!validCarNameLength(carList)) {
            throw new IllegalArgumentException(OVER_LENGTH.getMsg());
        } else if (!validEmptyName(carList)) {
            throw new IllegalArgumentException(EMPTY_KEYWORDS.getMsg());
        }
    }
    //이름 5자 이하 검증 로직
    private boolean validCarNameLength(List<String> carList) {
        int maxNameLength = 5;
        for (String car : carList) {
            if (car.length() > maxNameLength) {
                return false;
            }
        }
        return true;
    }
    //이름 빈 값 검증 로직
    private boolean validEmptyName(List<String> carList) {
        for (String car: carList) {
            if(car.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public List<String> getCarList() { // 🚀 검증된 자동차 목록을 컨트롤러에서 사용할 수 있도록 반환
        return carList;
    }
}
