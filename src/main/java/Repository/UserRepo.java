package Repository;

import Models.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {
    private Map<Long, User> userMap;

    public UserRepo() {
        this.userMap = new HashMap<>();
    }

}
