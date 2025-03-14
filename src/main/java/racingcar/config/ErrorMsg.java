package racingcar.config;

public enum ErrorMsg {
    OVER_LENGTH("5글자 초과"),
    EMPTY_KEYWORDS("빈 값 발견"),
    FIND_STRING("문자 발견");

    private final String msg;

    ErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
