package collections.simulator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import static collections.simulator.Helpers.getHand;

public class Hand implements Iterable<Card> {

    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return cards.toString();
    }

    public HandType getHandType() {
        if (isStraightFlush()) {
            return HandType.STRAIGHT_FLUSH;
        }

        if (isStraight() && !isFlush()) {
            return HandType.STRAIGHT;
        }

        if (isFourOfAKind()) {
            return HandType.FOUR_OF_A_KIND;
        }

        if (isFullHouse()) {
            return HandType.FULL_HOUSE;
        }

        return getHandTypeSubMethod();
    }


    private HandType getHandTypeSubMethod() {
        if (isTrips()) {
            return HandType.TRIPS;
        }

        if (isOnePair()) {
            return HandType.ONE_PAIR;
        }

        if (isTwoPair()) {
            return HandType.TWO_PAIRS;
        }
        if (isFlush()) {
            return HandType.FLUSH;
        }

        return HandType.HIGH_CARD;

    }


    public boolean contains(Card card) {
        return cards.contains(card);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }


    private boolean isOnePair() {
        return amountOfPairs() == 1;
    }

    private boolean isTwoPair() {
        return amountOfPairs() == 2;
    }


    private boolean isTrips() {
        boolean includesTrips = false;
        for (int i = 0; i < cards.size(); i++) {
            for (int j = 0; j < cards.size(); j++) {
                for (int k = 0; k < cards.size(); k++) {

                    if (i != j && i != k && j != k) {
                        Card.CardValue iValue = cards.get(i).getValue();
                        if (iValue == cards.get(j).getValue() && cards.get(k).getValue() == iValue) {
                            includesTrips = true;
                        }
                    }
                }
            }

        }
        return includesTrips;
    }


    private boolean isStraightFlush() {
        return isStraight() && isFlush();
    }


    private boolean isFourOfAKind() {
        boolean fourOfAKind = false;
        Collections.sort(cards);
        int count = 0;
        int setOfDuplicates = 0;

        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i - 1).getValue() == cards.get(i).getValue()) {
                count++;
            }
            if (i == cards.size() - 1 || cards.get(i - 1).getValue() != cards.get(i).getValue()) {
                setOfDuplicates = count;
                count = 0;
            }
            if (setOfDuplicates == 3) {
                break;
            }
        }
        if (setOfDuplicates == 3) {
            fourOfAKind = true;
        }

        return fourOfAKind;
    }

    private boolean isFullHouse() {
        int count = 0;

        boolean fullHouse = false;
        Collections.sort(cards);

        for (int i = 1; i < cards.size(); i++) {
            if (cards.get(i - 1).getValue() == cards.get(i).getValue()) {
                count++;
            }
        }
        if (isTrips() && amountOfPairs() == 2 && count == 3 && !isFourOfAKind()) {
            fullHouse = true;

        }
        return fullHouse;

    }



    private Boolean isStraight() {
        if (cards.size() != 5) {
            return false;
        } else {
            // sort the cards
            Collections.sort(cards);

            int i = 0;
            int prev = -1;
            // Iterate through the cards and see if the next card is exactly one more than
            //    the previous one.
            while (i + 1 != cards.size()) {
                if (cards.get(i).compareTo(cards.get(i + 1)) != prev && cards.get(0).compareTo(cards.get(i + 1)) != -12) {
                    return false;
                }
                i++;
            }
            return true;
        }
    }


    private Boolean isFlush() {
        boolean cardIsFlush = true;
        Card.CardSuit firsCardSuit = cards.get(0).getSuit();
        for (Card card : cards) {
            if (card.getSuit() == firsCardSuit) {
                continue;
            } else {
                cardIsFlush = false;
            }
        }
        return cardIsFlush;
    }


    private int amountOfPairs() {
        Collections.sort(cards);
        int pairs = 0;
        int i = 1;
        while (true) {
            if (i >= cards.size()) {
                break;
            }
            if (cards.get(i - 1).getValue() == cards.get(i).getValue()) {
                pairs += 1;
                i += 2;
                continue;
            }
            i++;

        }
        return pairs;
    }


    public static void main(String[] args) {

        Hand hand2 = getHand("AAKK");
        System.out.println(getHand("AAKKA"));
        System.out.println(hand2.isFlush());

        System.out.println(hand2.amountOfPairs());
        System.out.println(hand2.isFourOfAKind());
        System.out.println(getHand("AAA").getHandType());

    }
}
