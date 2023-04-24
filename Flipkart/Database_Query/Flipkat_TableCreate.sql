use Flipkart;
CREATE TABLE users (
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (username)
);

CREATE TABLE posts (
  id VARCHAR(255) NOT NULL,
  user_username VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  timestamp DATETIME NOT NULL,
  upvotes INT NOT NULL,
  downvotes INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_username) REFERENCES users(username)
);

CREATE TABLE comments (
  id VARCHAR(255) NOT NULL,
  user_username VARCHAR(255) NOT NULL,
  content TEXT NOT NULL,
  timestamp DATETIME NOT NULL,
  post_id VARCHAR(255),
  parent_comment_id VARCHAR(255),
  upvotes INT NOT NULL,
  downvotes INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (user_username) REFERENCES users(username),
  FOREIGN KEY (post_id) REFERENCES posts(id),
  FOREIGN KEY (parent_comment_id) REFERENCES comments(id)
);