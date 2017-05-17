INSERT INTO DEPARTMENT VALUES ('01', 'Billing', '507 Georgia Street','604-800-5000', 5, 'billing@ragequit.com');
INSERT INTO DEPARTMENT VALUES ('02', 'Customer Support', '645 New Westminster','778-667-4545', 5, 'support@ragequit.com');
INSERT INTO DEPARTMENT VALUES ('03', 'Developers', '400 Cambie Street','778-200-1222', 10, 'devteam@ragequit.com');

INSERT INTO REGION VALUES ('01', 'Asia', 'Hong Kong');
INSERT INTO REGION VALUES ('02', 'North America','Vancouver');
INSERT INTO REGION VALUES ('03', 'Europe','Berlin');

INSERT INTO Server VALUES ('Server1', 'TimePlaceH', 'WorldBossH', '2', 'PVE');
INSERT INTO Server VALUES ('Server2', 'TimePlaceH', 'WorldBossH', '2', 'PVE');
INSERT INTO Server VALUES ('Server3', 'TimePlaceH', 'WorldBossH', '2', 'PVE');

INSERT INTO PLAYERPERSONAL VALUES ('player1@mail.com', 'Player', 'One','M','01/01/80');
INSERT INTO PLAYERPERSONAL VALUES ('player2@mail.com', 'Player', 'Two','M','02/02/80');
INSERT INTO PLAYERPERSONAL VALUES ('player3@mail.com', 'Player', 'Three','F','03/03/80');
INSERT INTO PLAYERPERSONAL VALUES ('player4@mail.com', 'Player', 'Four','F','04/04/80');
INSERT INTO PLAYERPERSONAL VALUES ('player5@mail.com', 'Player', 'Five','F','05/05/80');
INSERT INTO PLAYERPERSONAL VALUES ('player6@mail.com', 'Player', 'Six','M','06/06/80');
INSERT INTO PLAYERPERSONAL VALUES ('player7@mail.com', 'Player', 'Seven','F','07/07/80');
INSERT INTO PLAYERPERSONAL VALUES ('player8@mail.com', 'Player', 'Eight','M','08/08/80');
INSERT INTO PLAYERPERSONAL VALUES ('player9@mail.com', 'Player', 'Nine','M','09/09/80');

INSERT INTO STAFFPERSONAL VALUES ('staff1@mail.com', 'Hue', 'One', 'Two','00-222-666');
INSERT INTO STAFFPERSONAL VALUES ('staff2@mail.com', 'Hue', 'Saya', 'John','00-222-666');
INSERT INTO STAFFPERSONAL VALUES ('staff3@mail.com', 'Hue', 'Carlos', 'Alex','00-222-666');
INSERT INTO STAFFPERSONAL VALUES ('staff4@mail.com', 'Hue', 'Don', 'Fabio','00-222-666');

INSERT INTO PLAYER VALUES ('01', '1st street', '1111111111', '111-111-1111', 'player1@mail.com');
INSERT INTO PLAYER VALUES ('02', '2nd street', '2222222222', '222-222-2222','player2@mail.com');
INSERT INTO PLAYER VALUES ('03', '3rd street', '3333333333', '333-333-3333','player3@mail.com');
INSERT INTO PLAYER VALUES ('04', '4th street', '4444444444', '444-444-4444','player4@mail.com');
INSERT INTO PLAYER VALUES ('05', '5th street', '5555555555', '555-555-5555','player5@mail.com');
INSERT INTO PLAYER VALUES ('06', '6th street', '6666666666', '666-666-6666','player6@mail.com');
INSERT INTO PLAYER VALUES ('07', '7th street', '7777777777', '777-777-7777','player7@mail.com');
INSERT INTO PLAYER VALUES ('08', '8th street', '8888888888', '888-888-8888','player8@mail.com');
INSERT INTO PLAYER VALUES ('09', '9th street', '9999999999', '999-999-9999','player9@mail.com');


INSERT INTO PLAYSIN VALUES ('01', 'Server1');
INSERT INTO PLAYSIN VALUES ('02', 'Server2');
INSERT INTO PLAYSIN VALUES ('03', 'Server1');

INSERT INTO LocatedIN VALUES ('01', 'Server2');
INSERT INTO LocatedIN VALUES ('02', 'Server3');
INSERT INTO LocatedIN VALUES ('03', 'Server1');

INSERT INTO STAFF VALUES ('01', 'staff1@mail.com', 'M', '01/01/90','99999','500','01','Designer','Server1');
INSERT INTO STAFF VALUES ('02', 'staff2@mail.com', 'M', '01/01/90','99999','500','02','Programmer','Server3');
INSERT INTO STAFF VALUES ('03', 'staff3@mail.com', 'M', '01/01/90','99999','500','03','DishWasher','Server2');
INSERT INTO STAFF VALUES ('04', 'staff4@mail.com', 'M', '01/01/90','99999','500','03','DishWasher','Server1');

INSERT INTO Supervise VALUES ('01', '02');
INSERT INTO Supervise VALUES ('02', '03');
INSERT INTO Supervise VALUES ('03', '01');


