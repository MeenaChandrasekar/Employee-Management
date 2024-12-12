CREATE TABLE IF NOT EXISTS QUESTION (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,  -- Use BIGINT to match Java Long
    question VARCHAR(255),
    optionA VARCHAR(255),
    optionB VARCHAR(255),
    optionC VARCHAR(255),
    optionD VARCHAR(255),
    correctAnswer CHAR(1)
);

INSERT INTO QUESTION (question, optionA, optionB, optionC, optionD, correctAnswer) 
VALUES 
('What is the capital of France?', 'Paris', 'Berlin', 'Madrid', 'Rome', 'A'),
('What is 2 + 2?', '3', '4', '5', '6', 'B'),
('Who wrote Hamlet?', 'Charles Dickens', 'William Shakespeare', 'Mark Twain', 'Leo Tolstoy', 'B');
