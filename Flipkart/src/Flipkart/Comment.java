package Flipkart;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Comment {
	private static final AtomicInteger ID_GENERATOR = new AtomicInteger(1);

	private final int id;
	private final User author;
	private final String content;
	private final LocalDateTime timestamp;
	private final Comment parent;
	private final List<Comment> replies;
	private int upvotes;
	private int downvotes;

	public Comment(User author, String content, Comment parent) {
		this.id = ID_GENERATOR.getAndIncrement();
		this.author = author;
		this.content = content;
		this.timestamp = LocalDateTime.now();
		this.parent = parent;
		this.replies = new ArrayList<>();
		this.upvotes = 0;
		this.downvotes = 0;
	}

	public void addReply(Comment reply) {
		replies.add(reply);
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

	public Comment getParent() {
		return parent;
	}

	public List<Comment> getReplies() {
		return replies;
	}

	// Getters and setters
	// ...
}
