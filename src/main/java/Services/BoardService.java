package Services;

import Models.Board;
import Models.Lists;
import Models.User;
import Repository.BoardRepo;

import java.util.List;

public class BoardService {
    private final BoardRepo boardRepo;

    public BoardService() {
        this.boardRepo = new BoardRepo();
    }

    public List<Board> findAllBoards() {
        return boardRepo.findAllBoards();
    }

    public Board findBoardById(Long id) {
        return boardRepo.findBoardById(id);
    }

    public Board createBoard(String boardName) {
        Board board = new Board(boardName);
        return boardRepo.saveBoard(board);
    }

    public Board saveListsForBoard(Long boardId, Lists lists) {
        return boardRepo.saveListsForBoard(boardId, lists);
    }

    // deleting a board should delete all lists inside of it
    public String deleteBoard(Long boardId) {
        Board board = boardRepo.findBoardById(boardId);
        if(board == null) return "No such board exists";
        boardRepo.deleteBoard(boardId);
        return "Board deleted successfully";
    }

    public User saveUserToList(User user, Long boardId) {
        boardRepo.addUserToBoard(boardId, user);
        return user;
    }

    public User removeUserFromList(User user, Long boardId) {
        Board board = boardRepo.findBoardById(boardId);
        if(board == null) return null;
        List<User> userList = board.getMembers();
        if(!userList.contains(user)) return null;
        userList.remove(user);
        boardRepo.addUsersToBoard(boardId, userList);
        return user;
    }

    public void addUsersToBoard(Long boardId, List<User> users) {
        boardRepo.addUsersToBoard(boardId, users);
    }
}
