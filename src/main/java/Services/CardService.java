package Services;

import Models.Card;
import Models.User;
import Repository.CardRepo;

public class CardService {
    private final CardRepo cardRepo;

    public CardService() {
        this.cardRepo = new CardRepo();
    }

    public Card findCardById(Long cardId) {
        return cardRepo.findCardById(cardId);
    }

    public Card createCard(String cardName, String cardDescription) {
        Card card = new Card(cardName, cardDescription);
        return cardRepo.saveCard(card.getCardId(), card);
    }


    public String deleteCard(Long cardId) {
        Card card = cardRepo.findCardById(cardId);
        if(card == null) return "No such card exists";
        cardRepo.deleteCard(cardId);
        return "Card deleted successfully";
    }

    public Card assignUserToCard(Long cardId, User user) {
        return cardRepo.assignCardToUser(cardId, user);
    }

    public Card unassignCardToUser(Long cardId) {
        return cardRepo.unassignCardToUser(cardId);
    }
}
