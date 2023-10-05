DROP TABLE "Admins";

CREATE TABLE "Admins" (
  `usuario` varchar(50) NOT NULL PRIMARY KEY,
  `contrasena` varchar(102) NOT NULL
);


INSERT INTO "Admins" VALUES
('Aldehil', 'pbkdf2:sha256:600000$FAhTzalCnmY15ljn$ba493709f7fce005ec3f1334003e3dc072f5d061026d4709b87dbae5aeaaa4df'), -- 12345
('Manja', 'pbkdf2:sha256:600000$qMhpBtIjN4BsozZt$030807f82615243981fed0e4da4d6cd035fa1f6d522839bd082c652017f099f7'); -- 54321
