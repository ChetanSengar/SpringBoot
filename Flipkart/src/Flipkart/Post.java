package Flipkart;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Post {
	private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

	private final int id;
	private final User author;
	private final String content;
	private final LocalDateTime timestamp;
	private final List<Comment> comments;
	private int upvotes;
	private int downvotes;
	private final Set<User> upvoters;
	private final Set<User> downvoters;

	public Post(User author, String content) {
		this.id = ID_GENERATOR.getAndIncrement();
		this.author = author;
		this.content = content;
		this.timestamp = LocalDateTime.now();
		this.comments = new ArrayList<>();
		this.upvotes = 0;
		this.downvotes = 0;
		this.upvoters = new HashSet<>();
		this.downvoters = new HashSet<>();
	}

	public int getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}

	public int getDownvotes() {
		return downvotes;
	}

	public void setDownvotes(int downvotes) {
		this.downvotes = downvotes;
	}

	public static AtomicInteger getIdGenerator() {
		return ID_GENERATOR;
	}

	public int getId() {
		return id;
	}

	public User getAuthor() {
		return author;
	}

	public String getContent() {
		return content;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void upvote() {
		upvotes++;
	}

	public void downvote() {
		downvotes++;
	}

	public boolean upvote(User user) {
		if (!upvoters.contains(user) && downvoters.remove(user)) {
			upvoters.add(user);
			upvotes++;
			return true;
		}
		return false;
	}

	public boolean downvote(User user) {
		if (!downvoters.contains(user) && upvoters.remove(user)) {
			downvoters.add(user);
			downvotes++;
			return true;
		}
		return false;
	}

	public double getScore() {
		return upvotes - downvotes;
	}

	// Getters and setters
	// ...
}
