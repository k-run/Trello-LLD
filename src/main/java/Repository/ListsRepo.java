package Repository;

import Models.Card;
import Models.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListsRepo {
    private final Map<Long, Lists> listsMap;

    public ListsRepo() {
        this.listsMap = new HashMap<>();
    }

    public Lists findListsById(Long listsId) {
        return listsMap.get(listsId);
    }

    public Lists saveLists(Long id, Lists list) {
        listsMap.put(id, list);
        return list;
    }

    public void deleteLists(Long listsId) {
       Lists lists = listsMap.remove(listsId);
       if(lists != null) {
           lists.getCardList().clear();
       }
    }

    public Lists saveCardsForLists(Long listsId, Card card) {
        Lists lists = listsMap.get(listsId);
        if(lists != null) {
            List<Card> cardList = lists.getCardList();
            cardList.add(card);
            lists.setCardList(cardList);
        }

        listsMap.put(listsId, lists);
        return lists;
    }
}
