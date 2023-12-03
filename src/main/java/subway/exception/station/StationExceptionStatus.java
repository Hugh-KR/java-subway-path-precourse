package subway.exception.station;

import subway.exception.ExceptionStatus;

public enum StationExceptionStatus implements ExceptionStatus {

    STATION_IS_DUPLICATED("출발역과 도착역이 동일합니다."),
    STATION_IS_EMPTY("존재하지 않는 역이름 입니다."),
    STATION_IS_NOT_SAME_LINE("두 역이 같은 노선이 아닙니다."),
    STATION_IS_INVALID_SEQUENCE("도착역이 출발역보다 앞서 있습니다.");


    private static final String MESSAGE_PREFIX = "\n[ERROR] ";

    private final String message;

    StationExceptionStatus(final String message) {
        this.message = MESSAGE_PREFIX + message;
    }

    public String getMessage() {
        return this.message;
    }
}
