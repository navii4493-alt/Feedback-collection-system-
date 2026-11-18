
CREATE DATABASE feedback_db;

USE feedback_db;

CREATE TABLE feedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_name VARCHAR(100),
    event_name VARCHAR(100),
    rating INT,
    comments VARCHAR(500),
    feedback_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
