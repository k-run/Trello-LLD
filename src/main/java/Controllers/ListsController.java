package Controllers;

import Models.Lists;
import Services.ListsService;

public class ListsController {
    private final ListsService listsService;

    public ListsController() {
        this.listsService = new ListsService();
    }

    // 8, 12, 13
    public Lists findListsById(Long listsId) {
        return listsService.findListsById(listsId);
    }

    // 7
    public Lists createLists(String listsName) {
        return listsService.createLists(listsName);
    }

    public String deleteLists(Long listsId) {
        return listsService.deleteLists(listsId);
    }
}
