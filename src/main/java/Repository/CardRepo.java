package Repository;

import Models.Card;
import Models.User;

import java.util.HashMap;
import java.util.Map;

public class CardRepo {
    private final Map<Long, Card> cardMap;

    public CardRepo() {
        this.cardMap = new HashMap<>();
    }

    public Card findCardById(Long cardId) {
        return cardMap.get(cardId);
    }

    public Card saveCard(Long cardId, Card card) {
        cardMap.put(cardId, card);
        return card;
    }

    public void deleteCard(Long cardId) {
        cardMap.remove(cardId);
    }

    public Card assignCardToUser(Long cardId, User user) {
        Card card = cardMap.get(cardId);
        if(card != null) card.setUser(user);
        cardMap.put(cardId, card);
        return card;
    }

    public Card unassignCardToUser(Long cardId) {
        Card card = cardMap.get(cardId);
        card.setUser(null);
        cardMap.put(cardId, card);
        return card;
    }
}
