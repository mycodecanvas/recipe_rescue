-- Difficulty level
INSERT INTO difficulty_level (level) VALUES ('EASY');
INSERT INTO difficulty_level (level) VALUES ('MEDIUM');
INSERT INTO difficulty_level (level) VALUES ('HARD');


-- Cuisines
INSERT INTO cuisine (name) VALUES ('ASIAN');
INSERT INTO cuisine (name) VALUES ('EUROPEAN');
INSERT INTO cuisine (name) VALUES ('LATIN');
INSERT INTO cuisine (name) VALUES ('NORTH_AMERICAN');
INSERT INTO cuisine (name) VALUES ('AFRICAN');

-- Prep Times
INSERT INTO prep_time_level (name) VALUES ('QUICK');
INSERT INTO prep_time_level (name) VALUES ('MODERATE');
INSERT INTO prep_time_level (name) VALUES ('LENGTHY');
INSERT INTO prep_time_level (name) VALUES ('ADVANCED');

-- User
INSERT INTO user_info (username, created_at, updated_at) VALUES ('hitran', now(), now());