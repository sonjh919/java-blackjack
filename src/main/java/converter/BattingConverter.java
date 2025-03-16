package converter;

import protocol.Request;

public class BattingConverter implements Converter<Integer> {
    private static final int MIN_MONEY_RANGE = 0;

    @Override
    public Integer convert(final Request<String> request) {
        int batting = validateInteger(request.data());
        validateRange(batting);

        return batting;
    }

    private int validateInteger(final String name) {
        try {
            return Integer.parseInt(name);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 배팅 금액은 숫자로 입력해 주세요.");
        }
    }

    private void validateRange(final int batting) {
        if (batting <= MIN_MONEY_RANGE) {
            throw new IllegalArgumentException("[ERROR] 알맞은 금액의 범위를 입력해주세요");
        }
    }

}
