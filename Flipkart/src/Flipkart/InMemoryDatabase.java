package Flipkart;

import java.util.Map;

public class InMemoryDatabase {
	private final Map<String, User> users;
	private final Map<String, Post> posts;
	private final Map<String, Comment> comments;

	public InMemoryDatabase(Map<String, User> users, Map<String, Post> posts, Map<String, Comment> comments) {
		super();
		this.users = users;
		this.posts = posts;
		this.comments = comments;
	}

	public Map<String, User> getUsers() {
		return users;
	}

	public Map<String, Post> getPosts() {
		return posts;
	}

	public Map<String, Comment> getComments() {
		return comments;
	}
}
