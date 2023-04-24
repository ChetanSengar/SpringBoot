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