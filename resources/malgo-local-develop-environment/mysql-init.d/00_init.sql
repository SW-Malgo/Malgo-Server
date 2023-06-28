CREATE
    USER 'malgo-local'@'localhost' IDENTIFIED BY 'malgo-local';
CREATE
    USER 'malgo-local'@'%' IDENTIFIED BY 'malgo-local';

GRANT ALL PRIVILEGES ON *.* TO
    'malgo-local'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO
    'malgo-local'@'%';

CREATE
    DATABASE malgo DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;