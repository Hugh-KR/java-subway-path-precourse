package subway.view.output.message;

public enum OutputMessage {

    READ_SELECT_MAIN_MESSAGE(
            """
            ## 메인 화면
            1. 경로 조회
            Q. 종료
                                        
            ## 원하는 기능을 선택하세요."""
    ),
    READ_SELECT_ROUTE_MESSAGE(
            """
            ## 경로 기준
            1. 최단 거리
            2. 최소 시간
            B. 돌아가기
                                                
            ## 원하는 기능을 선택하세요."""
    ),
    READ_SELECT_START_STATION_MESSAGE("## 출발역을 입력하세요."),
    READ_SELECT_END_STATION_MESSAGE("## 도착역을 입력하세요."),

    PRINT_RESULT_ROUTE_MESSAGE(
            """
            ## 조회 결과
            [INFO] ---
            [INFO] 총 거리: %dkm
            [INFO] 총 소요 시간: %d분
            [INFO] ---"""),
    PRINT_INFO_MESSAGE("[INFO] %s"),
    PRINT_EXIT_MESSAGE("지하철 노선도 경로 조회를 종료합니다.");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
