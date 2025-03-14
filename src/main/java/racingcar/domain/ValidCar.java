package racingcar.domain;

import java.util.List;

public class ValidCar {
    private final List<String> carList;

    ValidCar(List<String> carList) {
        test(carList);
        this.carList = carList;
    }

    //변수 초기화 전 에러 던지기
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
    public List<String> getCarList() { // 🚀 검증된 자동차 목록을 컨트롤러에서 사용할 수 있도록 반환
        return carList;
    }
}
