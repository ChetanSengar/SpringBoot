Read Me (Instructions):
Once you run the SocialNetworkApp.java application, you will see a command prompt interface where you can interact with the application. Here's what you should follow:

1-Start by creating a few user accounts using the signup command followed by a username and password, for example:

signup Alice password1
signup Bob password2
signup Charlie password3

2-Log in as one of the users using the login command followed by the username and password, for example:

login Alice password1

3-Create a new post using the post command followed by the content of the post, for example:

post This is my first post on the social network!

4-Log out and log in as another user to create more posts and interact with the application. Use the logout command to log out:

logout

5-After creating a few posts, use the timeline command to display the timeline of posts sorted by score:

timeline

6-Upvote or downvote posts using the upvote and downvote commands followed by the post ID, for example:

upvote 1
downvote 2

7-Comment on a post using the comment command followed by the post ID and the content of the comment, for example:

comment 1 This is a comment on Alice's post.

8-Reply to a comment using the reply command followed by the comment ID and the content of the reply, for example:

reply 1 This is a reply to the comment on Alice's post.

9-Use the viewpost command followed by the post ID to view a post along with its comments and replies, for example:

viewpost 1

10-Follow another user using the follow command followed by the username, for example:

follow Bob

11-Use the feed command to display the posts from the users you are following sorted by timestamp:

feed

Through these steps, we can test the various features of the application as per the original question. We have used MYSQL database(local machine) can also check the MySQL database to see how the data is being stored and updated with below query.
############################################################################################################

Database(MySQL): 

1-Creating tables and Database: 
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

2-Inputting some data in the tables for examples(test_purpose): 
use Flipkart; 

-- Insert users
INSERT INTO users (username, password) VALUES ('Alice', 'password1');
INSERT INTO users (username, password) VALUES ('Bob', 'password2');
INSERT INTO users (username, password) VALUES ('Charlie', 'password3');

-- Insert posts
INSERT INTO posts (id, user_username, content, timestamp, upvotes, downvotes) VALUES ('1', 'Alice', 'This is my first post on the social network!', '2023-04-22 12:00:00', 10, 2);
INSERT INTO posts (id, user_username, content, timestamp, upvotes, downvotes) VALUES ('2', 'Bob', 'Just joined this social network, looks cool!', '2023-04-22 12:30:00', 5, 1);
INSERT INTO posts (id, user_username, content, timestamp, upvotes, downvotes) VALUES ('3', 'Charlie', 'Check out my new blog post about AI!', '2023-04-22 13:00:00', 20, 4);

-- Insert comments
INSERT INTO comments (id, user_username, content, timestamp, post_id, parent_comment_id, upvotes, downvotes) VALUES ('1', 'Bob', 'Nice post, Alice!', '2023-04-22 12:15:00', '1', NULL, 3, 0);
INSERT INTO comments (id, user_username, content, timestamp, post_id, parent_comment_id, upvotes, downvotes) VALUES ('2', 'Alice', 'Thanks, Bob!', '2023-04-22 12:20:00', '1', '1', 2, 0);
INSERT INTO comments (id, user_username, content, timestamp, post_id, parent_comment_id, upvotes, downvotes) VALUES ('3', 'Charlie', 'I agree with Bob, great post!', '2023-04-22 12:25:00', '1', NULL, 4, 1);
INSERT INTO comments (id, user_username, content, timestamp, post_id, parent_comment_id, upvotes, downvotes) VALUES ('4', 'Alice', 'I read your blog post, Charlie. It was very interesting!', '2023-04-22 13:30:00', '3', NULL, 5, 0);

3-We’re almost ready to run the application now. 
