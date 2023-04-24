package Flipkart;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final String username;
    private final String password;
    private final Set<User> following;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.following = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<User> getFollowing() {
        return following;
    }

    public void follow(User user) {
        following.add(user);
    }
}
