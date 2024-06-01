package Controllers;

import Models.Card;
import Models.User;
import Services.CardService;

public class CardController {
    private final CardService cardService;

    public CardController() {
        this.cardService = new CardService();
    }

    public Card findCardById(Long cardId) {
        return cardService.findCardById(cardId);
    }

    // 10, 11
    public Card createCard(String cardName, String cardDescription) {
        return cardService.createCard(cardName, cardDescription);
    }

    public String deleteCard(Long cardId) {
        return cardService.deleteCard(cardId);
    }

    // 14
    public Card assignUserToCard(Long cardId, User user) {
        return cardService.assignUserToCard(cardId, user);
    }

    // 15
    public Card unassignCardToUser(Long cardId) {
        return cardService.unassignCardToUser(cardId);
    }

 }
