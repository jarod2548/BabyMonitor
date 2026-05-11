
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
    tekst VARCHAR(100),
    course_id BIGINT,

    CONSTRAINT fk_antwoord_vraag
        FOREIGN KEY (course_id)
            REFERENCES course(id)
            ON DELETE CASCADE
);