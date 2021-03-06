INSERT INTO roles (`id`, `type`) VALUES ('1', 'ROLE_ADMIN');
INSERT INTO users (`id`, `Enabled`, `Username`, `Password`, `mail`,`cash`,`webPurse`)
VALUES (1, true, 'sa', 'password', 'sa@mail.com', 0,'11111115');
INSERT INTO user_roles (`user_id`, `role_id`) VALUES ('1', '1');

INSERT INTO roles (`id`, `type`) VALUES ('2', 'ROLE_USER');
INSERT INTO users
(`id`,`Enabled`,`Password`,`Username`,`webPurse`,`mail`,`cash`) VALUES ('2',true,'password','Andrei','11111115','andrei@gmail.com','50000');
INSERT INTO user_roles (`user_id`, `role_id`) VALUES ('2', '2');

INSERT INTO nations (`id`, `continent`, `Name`) VALUES ('1', 'Europe', 'Europe');

INSERT INTO sport(`id`,`name`,`popularity`)VALUES ('1','soccer','8');

INSERT INTO tournament (`id`, `name`, `popularity`, `sport`) VALUES ('1', 'EURO2016', '6', '1');

INSERT INTO clubs (`id`, `Name`, `Nation`, `Popularity`, `Sport`) VALUES ('1', 'dinamo', '1', '6', '1');

INSERT INTO clubs (`id`, `Name`, `Nation`, `Popularity`, `Sport`) VALUES ('2', 'BATE', '1', '6', '1');

INSERT INTO clubs (`id`, `Name`, `Nation`, `Popularity`, `Sport`) VALUES ('3', 'Spartak', '1', '6', '1');

INSERT INTO clubs (`id`, `Name`, `Nation`, `Popularity`, `Sport`) VALUES ('4', 'Rubin', '1', '6', '1');

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateMatch`(in matchId bigint(20), in homeGoal bigint(20), in guestGoal bigint(20), in finish bit, in result1 bigint(20))
BEGIN
update totalizator_db.match set homeGoals=homeGoal where id=matchId;
update totalizator_db.match set guestGoals=guestGoal where id=matchId;
update totalizator_db.match set finished=finish where id=matchId;
update totalizator_db.match set result=result1 where id=matchId;
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `updateUserCash`(in userId bigint(20), in userCash float)
BEGIN
update users set cash = cash + userCash where id = userId;
END$$
DELIMITER ;