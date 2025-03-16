package converter;

import java.util.Arrays;
import java.util.List;
import protocol.Request;

public class NameConverter implements Converter<List<String>> {
    private static final int MAXIMUM_PLAYER_NUMBER = 6;

    @Override
    public List<String> convert(final Request<String> request) {
        List<String> names = Arrays.stream(request.data().split(","))
                .map(String::trim)
                .toList();

        validateIsDuplicate(names);
        validatePlayerNumbers(names);

        return names;
    }

    private void validatePlayerNumbers(final List<String> names) {
        if (names.isEmpty() || names.size() > MAXIMUM_PLAYER_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 플레이어 인원은 1~6명 입니다.");
        }
    }

    private void validateIsDuplicate(final List<String> names) {
        if (names.stream().distinct().count() != names.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름의 플레이어가 게임에 참여할 수 없습니다.");
        }
    }

}
