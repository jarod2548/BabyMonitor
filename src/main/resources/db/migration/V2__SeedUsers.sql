INSERT INTO USERS (ID, NAAM, WACHTWOORD, EMAIL, ROL)
VALUES
    ('1','test', '$argon2id$v=19$m=16384,t=3,p=1$kK1NC22AiSWIaq3ovC2MQg$Yq2F3xB8JvzdZ/MdJLr5dyPEP+ikrhDJCn4z9qHGXOI','test@example.com','TEACHER'),
    ('3','student', '$argon2id$v=19$m=16384,t=3,p=1$3ogmt9N3czj3RDqkGSI7pA$Q33v+04w5Berh4RB73j94E0GX4eS+sLhPurEZNirTns','student@gmail.com','USER')