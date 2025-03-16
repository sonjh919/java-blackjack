package converter;

public class AnswerConverter implements Converter<Boolean> {
    @Override
    public Boolean convert(final String request) {
        if (request.equals("y")) {
            return true;
        }

        if (request.equals("n")) {
            return false;
        }

        throw new IllegalArgumentException("[ERROR] y 또는 n으로 입력해주세요.");
    }
}
