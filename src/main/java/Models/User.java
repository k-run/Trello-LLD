package Models;

import java.util.concurrent.atomic.AtomicLong;

public class User {
    private final long userId;
    private String userName;
    private String userEmail;
    private static final AtomicLong counter = new AtomicLong();

    public long getUserId() {
        return userId;
    }

    public User(String userName, String userEmail) {
        this.userId = counter.getAndIncrement();
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                '}';
    }
}
