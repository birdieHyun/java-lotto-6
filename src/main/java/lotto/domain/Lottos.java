package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {

    private static final int START_NUMBER = 0;
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generate(int count, NumberGenerator numberGenerator) {
        List<Lotto> generatedLottos = IntStream.range(START_NUMBER, count)
                .mapToObj(i -> new Lotto(numberGenerator.generate()))
                .toList();
        return new Lottos(generatedLottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
