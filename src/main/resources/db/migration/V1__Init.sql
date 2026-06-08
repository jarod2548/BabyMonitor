
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    naam VARCHAR(100),
    wachtwoord VARCHAR(100),
    email VARCHAR(100) UNIQUE ,
    rol VARCHAR(100)
);

CREATE TABLE course (
    id BIGSERIAL PRIMARY KEY,
    titel VARCHAR(100),
    compleet BOOLEAN
);
CREATE TABLE ctg_data (
    id BIGSERIAL PRIMARY KEY,
    hartbasis int NOT NULL,
    varibiliteit int NOT NULL
);

CREATE TABLE vraag (
    id BIGSERIAL PRIMARY KEY,
    tekst VARCHAR(100),
    volgorde INT,
    course_id BIGINT,
    ctg_data_id BIGINT,

    CONSTRAINT fk_vraag_course
        FOREIGN KEY (course_id)
            REFERENCES course(id)
            ON DELETE CASCADE ,

    CONSTRAINT fk_vraag_ctg_data
        FOREIGN KEY (ctg_data_id)
            REFERENCES ctg_data(id)
            ON DELETE CASCADE
);

CREATE TABLE antwoord (
    id BIGSERIAL PRIMARY KEY ,
    tekst VARCHAR(100)
);

CREATE TABLE vraag_antwoord (
    id BIGSERIAL PRIMARY KEY,
    vraag_id BIGINT,
    antwoord_id BIGINT,

    CONSTRAINT fk_vraag
        FOREIGN KEY (vraag_id)
            REFERENCES vraag(id)
            ON DELETE CASCADE,

    CONSTRAINT fk_antwoord
        FOREIGN KEY (antwoord_id)
            REFERENCES antwoord(id)
            ON DELETE CASCADE
);

CREATE TABLE course_antwoord (
    course_id BIGINT NOT NULL,
    antwoord_id BIGINT NOT NULL,

    PRIMARY KEY (course_id, antwoord_id),

    CONSTRAINT fk_course_
        FOREIGN KEY (course_id)
            REFERENCES course(id)
            ON DELETE CASCADE ,
    CONSTRAINT fk_antwoord
        FOREIGN KEY (antwoord_id)
            REFERENCES antwoord(id)
            ON DELETE CASCADE
);

