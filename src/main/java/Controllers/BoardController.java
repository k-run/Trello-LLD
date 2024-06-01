package Controllers;

import Models.Board;
import Models.User;
import Services.BoardService;

import java.util.List;

public class BoardController {
    private final BoardService boardService;

    public BoardController() {
        this.boardService = new BoardService();
    }

    // 2, 6, 9
    public Board findBoardById(Long id) {
        return boardService.findBoardById(id);
    }

    // 1
    public Board createBoard(String boardName) {
        return boardService.createBoard(boardName);
    }

    // 5
    public String deleteBoard(Long boardId) {
        return boardService.deleteBoard(boardId);
    }

    // 3
    public User saveUserToList(User user, Long boardId) {
        return boardService.saveUserToList(user, boardId);
    }

    // 4
    public User removeUserFromList(User user, Long boardId) {
        return boardService.removeUserFromList(user, boardId);
    }

    public void addUsersToBoard(Long boardId, List<User> users) {
        boardService.addUsersToBoard(boardId, users);
    }


}
