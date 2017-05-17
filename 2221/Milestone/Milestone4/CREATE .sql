CREATE TABLE Server
( serverName VARCHAR(20) NOT NULL,
 timeZone VARCHAR(20) NOT NULL,
 worldBoss VARCHAR(20) NOT NULL,
 numberOfPlayers VARCHAR(3) NOT NULL,
 type VARCHAR(3) NOT NULL,
 PRIMARY KEY (serverName)
);
CREATE TABLE Region
( areaId NUMERIC(2) NOT NULL,
 RegionName VARCHAR(20) NOT NULL,
 HostLocation VARCHAR(20)NOT NULL,
 PRIMARY KEY (areaId)
);
CREATE TABLE Department
( departmentId NUMERIC(4) NOT NULL,
 departmentName VARCHAR(20) NOT NULL,
 departmentAddress VARCHAR(30) NOT NULL,
 departmentPhoneNo VARCHAR(20) NOT NULL,
 NoOfEmployee NUMERIC(10) NOT NULL,
 departmentEmail VARCHAR(20), 
 PRIMARY KEY (departmentId)

);
CREATE TABLE StaffPersonal
(
 StaffPersonalEmail VARCHAR(30) NOT NULL,
 StaffAddress VARCHAR(20) NOT NULL,
 FName VARCHAR(20) NOT NULL,
 LName VARCHAR(20) NOT NULL,
 StaffContactNo VARCHAR(20) NOT NULL,
 PRIMARY KEY (StaffPersonalEmail)
);
CREATE TABLE PlayerPersonal
(
 PlayerEmail VARCHAR(20) NOT NULL,
 FName VARCHAR(20) NOT NULL,
 LName VARCHAR(20) NOT NULL,
 Gender VARCHAR(1) NOT NULL,
 Birthday VARCHAR(10) NOT NULL,
 PRIMARY KEY (PlayerEmail)
);

CREATE TABLE Player
( 
 PlayerID NUMERIC(4) NOT NULL,
 PlayerAddress VARCHAR(20) NOT NULL,
 CreditCardNumber VARCHAR(20) NOT NULL,
 ContactNo VARCHAR(20) NOT NULL,
 PlayerEmail VARCHAR(20) NOT NULL,
 PRIMARY KEY (PlayerID),
 FOREIGN KEY (PlayerEmail) REFERENCES PlayerPersonal(PlayerEmail)
);


CREATE TABLE PlaysIn
( playerId NUMERIC(4) NOT NULL,
 serverName VARCHAR(20) NOT NULL,
 FOREIGN KEY (playerId) REFERENCES Player(playerId),
 FOREIGN KEY (serverName) REFERENCES Server(serverName)
);

CREATE TABLE LocatedIn
( areaId NUMERIC(2) NOT NULL,
 ServerName VARCHAR(20) NOT NULL,
 FOREIGN KEY (areaId) REFERENCES Region(areaId),
 FOREIGN KEY (serverName) REFERENCES Server(serverName)
);
CREATE TABLE Staff
( 
 StaffSSN NUMERIC(4),
 StaffPersonalEmail VARCHAR(30) NOT NULL,
 StaffGender VARCHAR(1) NOT NULL,
 StaffDOB VARCHAR(15) NOT NULL,
 Salary NUMERIC(10) NOT NULL,
 Bonus NUMERIC(10) NOT NULL,
 departmentId NUMERIC(4) NOT NULL,
 Position VARCHAR(15) NOT NULL,
 serverName VARCHAR(20) NOT NULL,
 PRIMARY KEY (StaffSSN),
 FOREIGN KEY (departmentId) REFERENCES Department(departmentId),
 FOREIGN KEY (StaffPersonalEmail) REFERENCES StaffPersonal(StaffPersonalEmail),
 FOREIGN KEY (serverName) REFERENCES Server(serverName)
);
CREATE TABLE Supervise
( staffId NUMERIC(4) NOT NULL,
 superviseStaffId NUMERIC(4) NOT NULL,
 FOREIGN KEY (staffId) REFERENCES staff(staffSSN),
 FOREIGN KEY (superviseStaffId) REFERENCES Staff(staffSSN)
);


