CREATE DATABASE Souvenirs;
use Souvenirs;
-- Создание таблицы "souvenirs"
CREATE TABLE Manufacturers (
    ManufacturerId INT PRIMARY KEY,
    Name VARCHAR(100),
    Country VARCHAR(100)
);

CREATE TABLE Souvenirs (
    SouvenirId INT PRIMARY KEY,
    Name VARCHAR(100),
    ManufacturerId INT,
    ReleaseDate DATE,
    Price DECIMAL(10, 2),
    FOREIGN KEY (ManufacturerId) REFERENCES Manufacturers(ManufacturerId)
);