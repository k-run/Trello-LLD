import Controllers.BoardController;
import Controllers.CardController;
import Controllers.ListsController;
import Models.Board;
import Models.Card;
import Models.Lists;
import Models.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        User Abc = new User("Abc", "abc@email.com");
        User john = new User("John", "john@email.com");
        User alice = new User("Alice", "alice@email.com");

        List<User> userList = List.of(Abc, john, alice);

        // Cards
        CardController cardController = new CardController();
        Card card1 = cardController.createCard("Production", "Smooth Release");
        cardController.assignUserToCard(card1.getCardId(), Abc);

        Card card2 = cardController.createCard("Feature Complete", "On Time");
        Card card3 = cardController.createCard("Perf", "Need to optimize");
        cardController.assignUserToCard(card3.getCardId(), john);

        // Lists
        ListsController listsController = new ListsController();
        Lists lists1 = listsController.createLists("What went well");
        lists1.setCardList(List.of(card1, card2));

        Lists lists2 = listsController.createLists("What can be improved");

        Lists lists3 = listsController.createLists("Action Items");
        lists3.setCardList(List.of(card3));

        BoardController boardController = new BoardController();
        Board board = boardController.createBoard("Sprint Retro");
        board.setBoardList(List.of(lists1, lists2, lists3));
        boardController.addUsersToBoard(board.getBoardId(), userList);

        System.out.println("board = " + board);

        Board board1 = boardController.createBoard("Sprint PLanning");
        board1.setBoardList(List.of(lists2, lists3));
        boardController.addUsersToBoard(board1.getBoardId(), List.of(Abc, alice));

        System.out.println("board1 = " + board1);
        System.out.println(boardController.deleteBoard(board1.getBoardId()));
        System.out.println(boardController.findBoardById(board1.getBoardId()));

        System.out.println(listsController.deleteLists(lists2.getListsId()));
        System.out.println(listsController.findListsById(lists2.getListsId()));

        boardController.removeUserFromList(Abc, board.getBoardId());
        System.out.println("board = " + board);

        cardController.unassignCardToUser(card3.getCardId());
        System.out.println("board = " + board);



    }
}
