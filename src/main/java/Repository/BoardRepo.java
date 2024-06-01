package Repository;

import Models.Board;
import Models.Lists;
import Models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardRepo {
    private final Map<Long, Board> boardMap;

    public BoardRepo() {
        this.boardMap = new HashMap<>();
    }

    public List<Board> findAllBoards() {
        return new ArrayList<>(boardMap.values());
    }

    public Board findBoardById(Long id) {
        return boardMap.get(id);
    }

    public Board saveBoard(Board board) {
        boardMap.put(board.getBoardId(), board);
        return board;
    }

    public Board saveListsForBoard(Long boardId, Lists lists) {
        Board board = findBoardById(boardId);
        if(board != null) {
            List<Lists> boardLists = board.getBoardList();
            boardLists.add(lists);
            board.setBoardList(boardLists);
        }

        boardMap.put(boardId, board);

        return board;
    }

    public void deleteBoard(Long boardId) {
        Board board = boardMap.remove(boardId);
        System.out.println("board in boardRepo = " + board);
        if(board != null) {
            System.out.println("board.getBoardList() = " + board.getBoardList());
            List<Lists> deletedLists = new ArrayList<>(board.getBoardList());
            deletedLists.clear();
        }
    }

    public void addUserToBoard(Long boardId, User user) {
        Board board = boardMap.get(boardId);
        if(board != null) {
            List<User> userList = board.getMembers();
            userList.add(user);
            board.setMembers(userList);
        }

        boardMap.put(boardId, board);
    }

    public void addUsersToBoard(Long boardId, List<User> users) {
        Board board = boardMap.get(boardId);
        if(board != null) {
            List<User> userList = board.getMembers();
            userList.addAll(users);
            board.setMembers(userList);
        }

        boardMap.put(boardId, board);
    }

}
