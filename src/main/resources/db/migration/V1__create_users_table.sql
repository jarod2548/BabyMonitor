
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    naam VARCHAR(100),
    wachtwoord VARCHAR(100),
    email VARCHAR(100),
    rol VARCHAR(100)
);