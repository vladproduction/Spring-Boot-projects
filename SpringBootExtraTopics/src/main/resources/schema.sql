CREATE TABLE IF NOT EXISTS room (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL,
                                    description VARCHAR(255),
                                    capacity INT,
                                    price INT
);

