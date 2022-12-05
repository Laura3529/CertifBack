CREATE TABLE channels(
    id INT PRIMARY KEY AUTO_INCREMENT,
    channel_name VARCHAR(255) NOT NULL,
    created_at DATE,
    updated_at DATE,
    description TEXT
);

CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    lastname VARCHAR(255) NOT NULL,
    firstname VARCHAR(255) NOT NULL,
    pseudo VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE TABLE users_channels(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id INT NOT NULL,
    channel_id INT NOT NULL,
    CONSTRAINT fk_user_channel_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_user_channel FOREIGN KEY (channel_id) REFERENCES channels(id)
);

CREATE TABLE messages(
    id INT PRIMARY KEY AUTO_INCREMENT,
    content TEXT NOT NULL,
    created_at DATE NOT NULL,
    updated_at DATE,
    user_id INT NOT NULL,
    channel_id INT NOT NULL,
    CONSTRAINT fk_message_user FOREIGN KEY (user_id) REFERENCES users(id),
    CONSTRAINT fk_message_channel FOREIGN KEY (channel_id) REFERENCES channels(id)
);











