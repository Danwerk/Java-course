package collections.simulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Simulator {

    @SuppressWarnings("PMD.UnusedPrivateField")
    private double iterations;
    Hand hand;
    List<Card> deck = new ArrayList<>();
    Map<HandType, Double> map;

    public Simulator(double iterations) {
        this.iterations = iterations;
    }

    public Map<HandType, Double> calculateProbabilities() {
        int counter = 0;
        for (int i = 0; i < iterations; i++) {
            Collections.shuffle(deck);
            hand = new Hand();
            for(int j = 0; j < 5; j++)
                hand.addCard(deck.get(j));
            if(hand.getHandType() == HandType.ONE_PAIR) {
                counter++;
            }

        }
        return map;

    }

    public double getWinningOdds(Hand player1hand, Hand player2hand) {
        throw new RuntimeException("not implemented yet");
    }

}
