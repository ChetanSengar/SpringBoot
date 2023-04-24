package Flipkart;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SocialNetworkApp {
    private static final SocialNetwork socialNetwork = new SocialNetwork();
    private static User loggedInUser = null;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String command;

            while (true) {
                command = scanner.nextLine();
                String[] commandParts = command.split(" ");
                String action = commandParts[0].toLowerCase();
                switch (action) {
                    case "signup":
                        handleSignup(commandParts);
                        break;
                    case "login":
                        handleLogin(commandParts);
                        break;
                    case "post":
                        handlePost(commandParts);
                        break;
                    case "follow":
                        handleFollow(commandParts);
                        break;
                    case "reply":
                        handleReply(commandParts);
                        break;
                    case "upvote":
                        handleUpvote(commandParts);
                        break;
                    case "downvote":
                        handleDownvote(commandParts);
                        break;
                    case "shownewsfeed":
                        handleShowNewsFeed(commandParts);
                        break;
                    case "logout":
                        handleLogout();
                        break;
                    case "exit":
                        System.exit(0);
                    default:
                        System.out.println("Invalid command.");
                }
            }
        }
    }

    private static void handleLogout() {
        if (loggedInUser == null) {
            System.out.println("You are not logged in.");
        } else {
            loggedInUser = null;
            System.out.println("Logged out successfully.");
        }
    }

    private static void handleSignup(String[] commandParts) {
        if (commandParts.length < 3) {
            System.out.println("Usage: signup <username> <password>");
            return;
        }

        String username = commandParts[1];
        String password = commandParts[2];

        User user = socialNetwork.signup(username, password);
        if (user != null) {
            System.out.println("User created successfully.");
        }
    }

    private static void handleLogin(String[] commandParts) {
        if (commandParts.length < 3) {
            System.out.println("Usage: login <username> <password>");
            return;
        }

        String username = commandParts[1];
        String password = commandParts[2];

        User user = socialNetwork.login(username, password);
        if (user != null) {
            loggedInUser = user;
            System.out.println("Logged in successfully.");
        }
    }

    private static void handlePost(String[] commandParts) {
        if (loggedInUser == null) {
            System.out.println("You must be logged in to create a post.");
            return;
        }

        if (commandParts.length < 2) {
            System.out.println("Usage: post <content>");
            return;
        }

        String content = String.join(" ", Arrays.copyOfRange(commandParts, 1, commandParts.length));
        Post post = socialNetwork.createPost(loggedInUser, content);
        System.out.println("Post created with ID: " + post.getId());
    }

    private static void handleFollow(String[] commandParts) {
        if (loggedInUser == null) {
            System.out.println("You must be logged in to follow a user.");
            return;
        }

        if (commandParts.length < 2) {
            System.out.println("Usage: follow <username>");
            return;
        }

        String username = commandParts[1];
        User followee = socialNetwork.getUserByUsername(username);

        if (followee != null) {
            socialNetwork.follow(loggedInUser, followee);
            System.out.println("You are now following " + followee.getUsername());
        } else {
            System.out.println("User not found.");
        }
    }

    private static void handleReply(String[] commandParts) {
        if (loggedInUser == null) {
            System.out.println("You must be logged in to reply.");
            return;
        }

        if (commandParts.length < 3) {
            System.out.println("Usage: reply <commentId> <content>");
            return;
        }

        int commentId = Integer.parseInt(commandParts[1]);
        Comment comment = socialNetwork.getCommentById(commentId);

        if (comment != null) {
            String content = String.join(" ", Arrays.copyOfRange(commandParts, 2, commandParts.length));
            socialNetwork.replyToComment(loggedInUser, comment, content);
            System.out.println("Reply added.");
        } else {
            System.out.println("Comment not found.");
        }
    }

    private static void handleUpvote(String[] commandParts) {
        if (loggedInUser == null) {
            System.out.println("You must be logged in to upvote.");
            return;
        }

        if (commandParts.length < 2) {
            System.out.println("Usage: upvote <postId>");
            return;
        }

        int postId = Integer.parseInt(commandParts[1]);
        Post post = socialNetwork.getPostById(postId);

        if (post != null) {
            boolean success = socialNetwork.upvotePost(loggedInUser, post);
            if (success) {
                System.out.println("Post upvoted.");
            } else {
                System.out.println("You've already upvoted this post.");
            }
        } else {
            System.out.println("Post not found.");
        }
    }

    private static void handleDownvote(String[] commandParts) {
        if (loggedInUser == null) {
            System.out.println("You must be logged in to downvote.");
            return;
        }

        if (commandParts.length < 2) {
            System.out.println("Usage: downvote <postId>");
            return;
        }

        int postId = Integer.parseInt(commandParts[1]);
        Post post = socialNetwork.getPostById(postId);

        if (post != null) {
            boolean success = socialNetwork.downvotePost(loggedInUser, post);
            if (success) {
                System.out.println("Post downvoted.");
            } else {
                System.out.println("You've already downvoted this post.");
            }
        } else {
            System.out.println("Post not found.");
        }
    }

    private static void handleShowNewsFeed(String[] commandParts) {
        if (loggedInUser == null) {
            System.out.println("You must be logged in to view your news feed.");
            return;
        }

        List<Post> newsFeed = socialNetwork.getNewsFeed(loggedInUser, SocialNetwork.SortOption.TIME);
        for (Post post : newsFeed) {
            System.out.println(post);
        }
    }
}
