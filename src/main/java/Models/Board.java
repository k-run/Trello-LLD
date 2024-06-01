package Models;

import Enums.Privacy;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class Board {
    private final long boardId;
    private String boardName;
    private Privacy privacy;
    private String boardURL;
    private List<User> members;
    private List<Lists> boardList;
    private static final AtomicLong counter = new AtomicLong();

    public long getBoardId() {
        return boardId;
    }

    public Board(String boardName) {
        this.boardId = counter.incrementAndGet();
        this.boardName = boardName;
        this.privacy = Privacy.getDefault();
        this.boardList = new ArrayList<>();
        this.members = new ArrayList<>();
        this.boardURL = "board-" + this.boardId + "-" + UUID.randomUUID().toString().substring(0, 7);
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardURL() {
        return boardURL;
    }

    public void setBoardURL(String boardURL) {
        this.boardURL = boardURL;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Lists> getBoardList() {
        return boardList;
    }

    public void setBoardList(List<Lists> boardList) {
        this.boardList = boardList;
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardId=" + boardId +
                "boardURL='" + boardURL + '\'' +
                ", boardName='" + boardName + '\'' +
                "members=" + members +
                "listsList=" + boardList +
                ", privacy=" + privacy +
                '}';
    }
}
