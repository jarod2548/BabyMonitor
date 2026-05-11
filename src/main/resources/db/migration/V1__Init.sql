
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    naam VARCHAR(100),
    wachtwoord VARCHAR(100),
    email VARCHAR(100) UNIQUE ,
    rol VARCHAR(100)
);

CREATE TABLE course (
    id BIGSERIAL PRIMARY KEY,
    titel VARCHAR(100)
);

CREATE TABLE vraag (
    id BIGSERIAL PRIMARY KEY,
    tekst VARCHAR(100),
    course_id BIGINT,

    CONSTRAINT fk_vraag_course
        FOREIGN KEY (course_id)
            REFERENCES course(id)
            ON DELETE CASCADE
);

CREATE TABLE antwoord (
    id BIGSERIAL PRIMARY KEY ,
    tekst VARCHAR(100)
);

CREATE TABLE courseantwoord (
    course_id BIGINT NOT NULL,
    antwoord_id BIGINT NOT NULL,
    PRIMARY KEY (course_id, antwoord_id),
    CONSTRAINT fk_course
        FOREIGN KEY (course_id)
            REFERENCES course(id)
            ON DELETE CASCADE,
    CONSTRAINT fk_antwoord
        FOREIGN KEY (antwoord_id)
            REFERENCES antwoord(id)
            ON DELETE CASCADE
);
