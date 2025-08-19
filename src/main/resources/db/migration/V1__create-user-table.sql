CREATE TABLE users (
                       id             UUID          DEFAULT RANDOM_UUID() PRIMARY KEY,
                       name           VARCHAR(255)  NOT NULL,
                       email          VARCHAR(255)  NOT NULL UNIQUE,
                       password_hash  VARCHAR(400)  NOT NULL,
                       active         BOOLEAN       NOT NULL DEFAULT TRUE,
                       created_at     TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       updated_at     TIMESTAMP     NULL
);
