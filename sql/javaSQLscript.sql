-- Active: 1723736230599@@127.0.0.1@1433@PEVEC
CREATE DATABASE PEVEC GO ˆ

USE PEVEC 
SELECT pl.ID, pl.Common, pl.Botanical, Family.FamilyName, Conservation.ConservationName, pl.[Description], pl.Picture, [Zone].ZoneName, Light.LightName, pl.Price, pl.[Availability]
FROM Plant as pl
INNER JOIN Family ON pl.FamilyID = Family.ID
INNER JOIN Conservation ON pl.ConservationID = Conservation.ID
INNER JOIN [Zone] ON pl.ZoneID = [Zone].ID
INNER JOIN Light ON pl.LightID = Light.ID
GO

CREATE TABLE [User] (
    ID INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
    Username NVARCHAR(50) NOT NULL,
    Password NVARCHAR(50) NOT NULL,
    Admin bit NOT NULL,
)
 go

CREATE TABLE Family (
    ID int primary key not null IDENTITY(1, 1),
    FamilyName NVARCHAR(100) NOT NULL
) 
go

CREATE TABLE Conservation (
    ID int primary key not null IDENTITY(1, 1),
    ConservationName NVARCHAR(5) NOT NULL
) 
go


CREATE TABLE [Zone] (
    ID int primary key not null IDENTITY(1, 1),
    ZoneName NVARCHAR(30) NOT NULL
) 
go

CREATE TABLE Light (
    ID int primary key not null IDENTITY(1, 1),
    LightName NVARCHAR(100) NOT NULL
) 
go


CREATE TABLE Plant (
    ID INT PRIMARY KEY NOT NULL IDENTITY(1, 1),
    Common NVARCHAR(100) NOT NULL,
    Botanical NVARCHAR(100) NOT NULL,
    FamilyID int not null foreign key references Family (ID) on delete cascade,
    ConservationID int not null foreign key references Conservation (ID) on delete cascade,
    [Description] NVARCHAR(max) NOT NULL,
    Picture NVARCHAR(200) NOT NULL,
    ZoneID int not null foreign key references [Zone] (ID) on delete cascade,
    LightID int not null foreign key references Light (ID) on delete cascade,
    Price DECIMAL(10, 2) NOT NULL,
    [Availability] INT NOT NULL
)
go

--- PLANT TABLE DATA
CREATE OR ALTER PROC CreatePlant
    @Common NVARCHAR(100),
    @Botanical NVARCHAR(100),
    @FamilyID INT,
    @ConservationID INT,
    @Description NVARCHAR(max),
    @Picture NVARCHAR(200),
    @ZoneID INT,
    @LightID INT,
    @Price DECIMAL(10,2),
    @Availability INT,
    @ID INT OUTPUT
AS
BEGIN    
    INSERT INTO Plant (Common, Botanical, FamilyID, ConservationID, [Description], Picture, ZoneID, LightID, Price, [Availability])
    VALUES (@Common, @Botanical, @FamilyID, @ConservationID, @Description, @Picture, @ZoneID, @LightID, @Price, @Availability)
    set @ID = SCOPE_IDENTITY() 
END
;

CREATE OR ALTER PROC UpdatePlant
    @ID INT,
    @Common NVARCHAR(100),
    @Botanical NVARCHAR(100),
    @FamilyID INT,
    @ConservationID INT,
    @Description NVARCHAR(max),
    @Picture NVARCHAR(200),
    @ZoneID INT,
    @LightID INT,
    @Price DECIMAL(10,2),
    @Availability INT
AS
BEGIN
    UPDATE Plant
    SET Common = @Common, Botanical = @Botanical, FamilyID = @FamilyID, ConservationID = @ConservationID, [Description] = @Description, Picture = @Picture, ZoneID = @ZoneID, LightID = @LightID, Price = @Price, [Availability] = @Availability
    WHERE ID = @ID
END

CREATE OR ALTER PROC DeletePlant
    @ID INT
AS
BEGIN
    DELETE FROM Plant
    WHERE ID = @ID
END
Go

create or alter proc DeleteAllPlants
as
begin
    delete from Plant
end
go

CREATE OR ALTER PROC GetPlant
    @ID INT
AS
BEGIN
    SELECT pl.ID, pl.Common, pl.Botanical, pl.FamilyID, Family.FamilyName, pl.ConservationID, Conservation.ConservationName, pl.[Description], pl.Picture, pl.ZoneID, [Zone].ZoneName, pl.LightID, Light.LightName, pl.Price, pl.[Availability]
FROM Plant as pl
INNER JOIN Family ON pl.FamilyID = Family.ID
INNER JOIN Conservation ON pl.ConservationID = Conservation.ID
INNER JOIN [Zone] ON pl.ZoneID = [Zone].ID
INNER JOIN Light ON pl.LightID = Light.ID
    WHERE pl.ID = @ID
END

CREATE OR ALTER PROC GetAllPlants
AS
BEGIN
    SELECT pl.ID, pl.Common, pl.Botanical, pl.FamilyID, Family.FamilyName, pl.ConservationID, Conservation.ConservationName, pl.[Description], pl.Picture, pl.ZoneID, [Zone].ZoneName, pl.LightID, Light.LightName, pl.Price, pl.[Availability]
FROM Plant as pl
INNER JOIN Family ON pl.FamilyID = Family.ID
INNER JOIN Conservation ON pl.ConservationID = Conservation.ID
INNER JOIN [Zone] ON pl.ZoneID = [Zone].ID
INNER JOIN Light ON pl.LightID = Light.ID
END

CREATE OR ALTER PROCEDURE CreateFamily
    @FamilyName NVARCHAR(100),
    @ID INT OUTPUT
AS
BEGIN    
        INSERT INTO [Family] (FamilyName)
        VALUES (@FamilyName)
        set @ID = SCOPE_IDENTITY() 
END
go
---------------------
CREATE OR ALTER PROCEDURE CreateConservation
    @ConservationName NVARCHAR(5),
    @ID INT OUTPUT
AS
BEGIN
        INSERT INTO Conservation (ConservationName)
        VALUES (@ConservationName)
        set @ID = SCOPE_IDENTITY() 
END
go

CREATE OR ALTER PROCEDURE CreateZone
    @ZoneName NVARCHAR(30),
    @ID INT OUTPUT
AS
BEGIN
        INSERT INTO [Zone] (ZoneName)
        VALUES (@ZoneName)
set @ID = SCOPE_IDENTITY() 
    END
go

CREATE OR ALTER PROCEDURE CreateLight
    @LightName NVARCHAR(100),
    @ID INT OUTPUT
AS
BEGIN
        begin
        INSERT INTO Light (LightName)
        VALUES (@LightName)
set @ID = SCOPE_IDENTITY() 
    END
go

CREATE OR ALTER PROC GetFamily
    @ID INT
AS
BEGIN
    SELECT * FROM Family
    WHERE ID = @ID
END

CREATE OR ALTER PROC GetConservation
    @ID INT
AS
BEGIN
    SELECT * FROM Conservation
    WHERE ID = @ID
END

CREATE OR ALTER PROC GetZone
    @ID INT
AS
BEGIN
    SELECT * FROM [Zone]
    WHERE ID = @ID
END

CREATE OR ALTER PROC GetLight
    @ID INT
AS
BEGIN
    SELECT * FROM Light
    WHERE ID = @ID
END

CREATE OR ALTER PROC GetAllFamilies
AS
BEGIN
    SELECT * FROM Family
END

CREATE OR ALTER PROC GetAllConservations
AS
BEGIN
    SELECT * FROM Conservation
END

CREATE OR ALTER PROC GetAllZones
AS
BEGIN
    SELECT * FROM [Zone]
END

CREATE OR ALTER PROC GetAllLights
AS
BEGIN
    SELECT * FROM Light
END

CREATE OR ALTER PROC UpdateFamily
    @ID INT,
    @FamilyName NVARCHAR(100)
AS
BEGIN
    UPDATE [Family]
    SET FamilyName = @FamilyName
    WHERE ID = @ID
END

CREATE OR ALTER PROC UpdateConservation
    @ID INT,
    @ConservationName NVARCHAR(5)
AS
BEGIN
    UPDATE ConservationName
    SET ConservationName = @ConservationName
    WHERE ID = @ID
END

CREATE OR ALTER PROC UpdateZone
    @ID INT,
    @ZoneName NVARCHAR(5)
AS
BEGIN
    UPDATE [Zone]
    SET ZoneName = @ZoneName
    WHERE ID = @ID
END

CREATE OR ALTER PROC UpdateLight
    @ID INT,
    @LightName NVARCHAR(100)
AS
BEGIN
    UPDATE Light
    SET LightName = @LightName
    WHERE ID = @ID
END

CREATE OR ALTER PROC DeleteFamily
    @ID INT
AS
BEGIN
    DELETE FROM Family
    WHERE ID = @ID
END

CREATE OR ALTER PROC DeleteConservation
    @ID INT
AS
BEGIN
    DELETE FROM Conservation
    WHERE ID = @ID
END

CREATE OR ALTER PROC DeleteZone
    @ID INT
AS
BEGIN
    DELETE FROM [Zone]
    WHERE ID = @ID
END

CREATE OR ALTER PROC DeleteLight
    @ID INT
AS
BEGIN
    DELETE FROM Light
    WHERE ID = @ID
END
Go  
CREATE OR ALTER PROCEDURE DeleteAllFamilies
AS
BEGIN
    DELETE FROM Family
END
GO

CREATE OR ALTER PROCEDURE DeleteAllConservations
AS
BEGIN
    DELETE FROM Conservation
END
GO

CREATE OR ALTER PROCEDURE DeleteAllZones
AS
BEGIN
    DELETE FROM [Zone]
END
GO

CREATE OR ALTER PROCEDURE DeleteAllLights
AS
BEGIN
    DELETE FROM Light
END
GO

-- user stuff

CREATE OR ALTER PROC CreateUser
    @Username NVARCHAR(50),
    @Password NVARCHAR(50),
    @Admin bit,
    @ID INT OUTPUT
AS
BEGIN
        INSERT INTO [User] (Username, Password, Admin)
        VALUES (@Username, @Password, @Admin)
        set @ID = SCOPE_IDENTITY() 
END
go

CREATE OR ALTER PROC GetUser
    @ID INT
AS
BEGIN
    SELECT * FROM [User]
    WHERE ID = @ID
END

CREATE or alter PROCEDURE GetAllUsers
AS
BEGIN
    SELECT * FROM [User]
END

CREATE OR ALTER PROC UpdateUser
    @ID INT,
    @Username NVARCHAR(50),
    @Password NVARCHAR(50)
AS
BEGIN
    UPDATE [User]
    SET Username = @Username, Password = @Password, Admin = 0
    WHERE ID = @ID
END

CREATE OR ALTER PROC DeleteUser
    @ID INT 
AS
BEGIN
    DELETE FROM [User]
    WHERE ID = @ID
END

CREATE OR ALTER PROCEDURE DeleteAllUsers
AS
BEGIN
    DELETE FROM [User]
    WHERE Admin <> 1
END

--- Admin stuff
declare @adminID int
exec CreateUser @Username = 'admin', @Password = 'password' @Admin = 1, @ID =  @adminID OUTPUT
--- Admin stuff


--- TEST DATA BEGIN


-- EXEC CreateFamily @FamilyName = 'Acanthaceae'
-- EXEC CreateFamily @FamilyName = 'Nyctaginaceae'
-- EXEC CreateConservation @ConservationName = 'LC'
-- EXEC CreateZone @ZoneName = '10'
-- EXEC CreateLight @LightName = 'Full Sun'


-- declare @biljkicaID int

-- EXEC CreatePlant @Common = 'Firecracker Plant',
-- @Botanical = 'Russelia equisetiformis',
-- @FamilyID = 8,
-- @ConservationID = 2,
-- @Description = 'Firecracker Plant is a fast-growing, evergreen shrub that produces tubular, red flowers throughout the year. It is a great plant for attracting hummingbirds to the garden.',
-- @Picture = 'https://www.gardeningknowhow.com/wp-content/uploads/2019/07/firecracker-plant.jpg',
-- @ZoneID = 2,
-- @LightID = 2,
-- @Price = 9.99,
-- @Availability = 10,
-- @ID = @biljkicaID OUTPUT 

-- select @biljkicaID

-- EXEC CreatePlant @Common = 'Bougainvillea',
-- @Botanical = 'Bougainvillea spectabilis',
-- @FamilyID = 9,
-- @ConservationID = 2,
-- @Description = 'Bougainvillea is a tropical vine that can grow up to 30 feet tall. It produces colorful bracts in shades of pink, red, purple, and white.',
-- @Picture = 'https://www.gardeningknowhow.com/wp-content/uploads/2019/07/bougainvillea.jpg',
-- @ZoneID = 2,
-- @LightID = 2,
-- @Price = 14.99,
-- @Availability = 5, 
-- @ID = @biljkicaID OUTPUT 


-- declare @korisnikID int
-- EXEC CreateUser @Username = 'user12', @Password = 'password1', @Admin = 0, @ID =  @korisnikID OUTPUT
-- EXEC CreateUser @Username = 'user21', @Password = 'password2', @Admin = 0, @ID =  @korisnikID OUTPUT

-- exec GetAllPlants
--- TEST DATA END


-- --- TEST delete all data
-- USE PEVEC 
-- EXEC DeleteAllPlants
-- EXEC DeleteAllFamilies
-- EXEC DeleteAllConservations
-- EXEC DeleteAllZones
-- EXEC DeleteAllLights
-- EXEC DeleteAllUsers

-- drop TABLE zone
--- TEST delete all data
use PEVEC
select * from User

