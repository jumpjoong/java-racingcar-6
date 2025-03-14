package racingcar.config;

public enum RuleMsg {
    START_MSG("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    TRY_COUNT_MSG("시도할 회수는 몇 회인가요?");

    private final String msg;

    RuleMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
