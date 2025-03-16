package converter;

import protocol.Request;

public class AnswerConverter implements Converter<Boolean> {
    @Override
    public Boolean convert(Request<String> request) {
        if (request.data().equals("y")) {
            return true;
        }

        if (request.data().equals("n")) {
            return false;
        }

        throw new IllegalArgumentException("[ERROR] y 또는 n으로 입력해주세요.");
    }
}
