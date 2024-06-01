package Services;

import Models.Card;
import Models.Lists;
import Repository.ListsRepo;

public class ListsService {
    private final ListsRepo listsRepo;

    public ListsService() {
        this.listsRepo = new ListsRepo();
    }

    public Lists findListsById(Long listsId) {
        return listsRepo.findListsById(listsId);
    }

    public Lists createLists(String listsName) {
        Lists lists = new Lists(listsName);
       
        return listsRepo.saveLists(lists.getListsId(), lists);
    }

    public Lists saveCardForLists(Long listsId, Card card) {
        return listsRepo.saveCardsForLists(listsId, card);
    }
   
    public String deleteLists(Long listsId) {
        Lists lists = listsRepo.findListsById(listsId);
        if(lists == null) return "No such lists exists";
        listsRepo.deleteLists(listsId);
        return "Lists deleted successfully";
    }
}
