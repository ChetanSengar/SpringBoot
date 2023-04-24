package Flipkart;

import java.util.*;
import java.util.stream.Collectors;

public class SocialNetwork {
    private final Map<String, User> users;
    private final List<Post> posts;
    private final List<Comment> comments;

    public SocialNetwork() {
        users = new HashMap<>();
        posts = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public User signup(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username is already taken.");
            return null;
        }

        User newUser = new User(username, password);
        users.put(username, newUser);
        return newUser;
    }

    public User login(String username, String password) {
        User user = users.get(username);

        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }

    public Post createPost(User user, String content) {
        Post newPost = new Post(user, content);
        posts.add(newPost);
        return newPost;
    }

    public void follow(User follower, User followee) {
        follower.follow(followee);
    }

    public Comment getCommentById(int commentId) {
        return comments.stream()
                .filter(comment -> comment.getId() == commentId)
                .findFirst()
                .orElse(null);
    }

    public Post getPostById(int postId) {
        return posts.stream()
                .filter(post -> post.getId() == postId)
                .findFirst()
                .orElse(null);
    }

    public boolean upvotePost(User user, Post post) {
        return post.upvote(user);
    }

    public boolean downvotePost(User user, Post post) {
        return post.downvote(user);
    }
    
    public User getUserByUsername(String username) {
        return users.get(username);
    }

    public void replyToComment(User user, Comment parentComment, String content) {
        Comment reply = new Comment(user, content, parentComment);
        parentComment.addReply(reply);
        comments.add(reply);
    }

    public List<Post> getNewsFeed(User user, SortOption sortOption) {
        Set<User> followees = user.getFollowing();
        List<Post> newsFeedPosts = posts.stream()
                .filter(post -> followees.contains(post.getAuthor()))
                .collect(Collectors.toList());

        switch (sortOption) {
            case TIME:
                newsFeedPosts.sort(Comparator.comparing(Post::getTimestamp).reversed());
                break;
            case SCORE:
                newsFeedPosts.sort(Comparator.comparing(Post::getScore).reversed());
                break;
        }

        return newsFeedPosts;
    }

    public enum SortOption {
        TIME,
        SCORE
    }
}
