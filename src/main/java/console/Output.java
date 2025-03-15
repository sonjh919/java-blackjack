package console;

public class Output {
    private static final String NEW_LINE = System.lineSeparator();


    public void name(){
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
    }

    public void batting(String name) {
        System.out.printf("%s의 배팅 금액은?" + NEW_LINE, name);
    }


}
