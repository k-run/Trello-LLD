package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class Lists {
    private final long listsId;
    private String listsName;
    private List<Card> cardList;
    private static final AtomicLong counter = new AtomicLong();

    public Lists(String listsName) {
        this.listsName = listsName;
        this.listsId = counter.getAndIncrement();
        this.cardList = new ArrayList<>();
    }

    public long getListsId() {
        return listsId;
    }

    public String getListsName() {
        return listsName;
    }

    public void setListsName(String listsName) {
        this.listsName = listsName;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }


    @Override
    public String toString() {
        return "Lists{" +
                "listsId=" + listsId +
                ", listsName='" + listsName + '\'' +
                ", cardList=" + cardList +
                '}';
    }
}
