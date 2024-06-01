package Models;

import java.util.concurrent.atomic.AtomicLong;

public class Card {
    private final long cardId;
    private String cardName;
    private String cardDescription;
    private User user;
    private static final AtomicLong counter = new AtomicLong();

    public Card(String cardName, String cardDescription) {
        this.cardName = cardName;
        this.cardDescription = cardDescription;
        this.cardId = counter.getAndIncrement();
        this.user = null;
    }

    public long getCardId() {
        return cardId;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardDescription() {
        return cardDescription;
    }

    public void setCardDescription(String cardDescription) {
        this.cardDescription = cardDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cardName='" + cardName + '\'' +
                ", cardDescription='" + cardDescription + '\'' +
                ", user=" + user +
                '}';
    }
}
