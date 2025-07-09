CREATE TABLE IF NOT EXISTS `difficulty_level`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    level VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS `serving_size`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    serving INT NOT NULL
);

CREATE TABLE IF NOT EXISTS `prep_time_level`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS `cuisine`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS `category`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    category VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS `unit`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS `user_info`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    difficulty_id INT,
    serving_size_id INT,
    prep_time_id INT,
    cuisine_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (difficulty_id) REFERENCES difficulty_level(id),
    FOREIGN KEY (serving_size_id) REFERENCES serving_size(id),
    FOREIGN KEY (prep_time_id) REFERENCES prep_time_level(id),
    FOREIGN KEY (cuisine_id) REFERENCES cuisine(id)
);

CREATE TABLE IF NOT EXISTS `ingredient`(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    category INT,
    unit_id INT,
    FOREIGN KEY (category) REFERENCES category(id),
    FOREIGN KEY (unit_id) REFERENCES unit(id)
);

CREATE TABLE IF NOT EXISTS `user_ingredient`(
    user_id INT NOT NULL,
    ingredient_id INT NOT NULL,
    quantity INT,
    expiry_date DATE,
    FOREIGN KEY (user_id) REFERENCES user_info(id),
    FOREIGN KEY (ingredient_id) REFERENCES ingredient(id),
    PRIMARY KEY (user_id, ingredient_id)
);