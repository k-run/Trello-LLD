package Services;

import Models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private final Map<Long, User> userMap;

    public UserService() {
        this.userMap = new HashMap<>();
    }

    public User createUser(User user) {
        userMap.put(user.getUserId(), user);
        return user;
    }

    public User findUserById(Long id) {
        return userMap.get(id);
    }

    public void deleteUser(Long id) {
        userMap.remove(id);
    }
}
