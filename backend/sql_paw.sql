-- Drop tables if they exist
DROP TABLE IF EXISTS userprogress;
DROP TABLE IF EXISTS exercises;
DROP TABLE IF EXISTS sections;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS levels;

-- Create levels table
CREATE TABLE levels (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(2) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create users table
CREATE TABLE users (
                       id_user INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(20) NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(250) NOT NULL,
                       role ENUM('ADMIN', 'STUDENT') DEFAULT 'STUDENT',
                       levels_id_lvl INT NOT NULL,
                       CONSTRAINT users_username_email_un UNIQUE (username, email),
                       CONSTRAINT users_levels_fk FOREIGN KEY (levels_id_lvl) REFERENCES levels(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create courses table
CREATE TABLE courses (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         orderNum INT NOT NULL,
                         title VARCHAR(250) NOT NULL,
                         levels_id_lvl INT NOT NULL,
                         CONSTRAINT courses_levels_fk FOREIGN KEY (levels_id_lvl) REFERENCES levels(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create sections table
CREATE TABLE sections (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          orderNum INT,
                          type VARCHAR(15),
                          sections_course_fk INT NOT NULL,
                          CONSTRAINT sections_courses_fk FOREIGN KEY (sections_course_fk) REFERENCES courses(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create exercises table
CREATE TABLE exercises (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           orderNum INT,
                           type VARCHAR(10),
                           content TEXT,
                           exercises_section_fk INT NOT NULL,
                           CONSTRAINT exercises_sections_fk FOREIGN KEY (exercises_section_fk) REFERENCES sections(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Create userprogress table
CREATE TABLE userprogress (
                              id_usrprg INT AUTO_INCREMENT PRIMARY KEY,
                              status VARCHAR(15) DEFAULT 'not_completed',
                              score DECIMAL(5,2),
                              courses_id_cs INT NOT NULL,
                              courses_levels_id_lvl INT NOT NULL,
                              users_id_user INT NOT NULL,
                              CONSTRAINT userprogress_courses_fk FOREIGN KEY (courses_id_cs) REFERENCES courses(id),
                              CONSTRAINT userprogress_users_fk FOREIGN KEY (users_id_user) REFERENCES users(id_user),
                              CONSTRAINT unique_user_course UNIQUE (users_id_user, courses_id_cs)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Insert sample levels
INSERT INTO levels (name) VALUES ('A1'), ('A2'), ('B1'), ('B2'), ('C1'), ('C2');