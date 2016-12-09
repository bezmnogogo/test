CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_q9npl2ty4pngm2cussiul2qj5` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Enabled` bit(1) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `webPurse` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `cash` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tbpk8dt8cn41jgc3c5cjmulf1` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE `user_roles` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKej3jidxlte0r8flpavhiso3g6` (`role_id`),
  CONSTRAINT `FK7ov27fyo7ebsvada1ej7qkphl` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKej3jidxlte0r8flpavhiso3g6` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `nations` (
  `id` bigint(20) NOT NULL,
  `continent` varchar(255) DEFAULT NULL,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `sport` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `popularity` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tournament` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `popularity` bigint(20) NOT NULL,
  `sport` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjphjbqxt91awd7dy9afw46gm0` (`sport`),
  CONSTRAINT `FKjphjbqxt91awd7dy9afw46gm0` FOREIGN KEY (`sport`) REFERENCES `sport` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `clubs` (
  `id` bigint(20) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Nation` bigint(20) DEFAULT NULL,
  `Popularity` bigint(20) NOT NULL,
  `Sport` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9nsyu967fel54830mo51br6wr` (`Nation`),
  KEY `FK9929gh3qpf3b5tg71ear0nh9t` (`Sport`),
  CONSTRAINT `FK27bhea6hgsd1js1v3wq2ddyxi` FOREIGN KEY (`Nation`) REFERENCES `nations` (`id`),
  CONSTRAINT `FK9929gh3qpf3b5tg71ear0nh9t` FOREIGN KEY (`Sport`) REFERENCES `sport` (`id`),
  CONSTRAINT `FK9nsyu967fel54830mo51br6wr` FOREIGN KEY (`Nation`) REFERENCES `nations` (`id`),
  CONSTRAINT `FKr8wsrwsaa7ktn6222x1i2k01` FOREIGN KEY (`Sport`) REFERENCES `sport` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tournamentTeams` (
  `id` bigint(20) NOT NULL,
  `club` bigint(20) DEFAULT NULL,
  `tournament` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3hw08yl5tfk17dqfjo410plns` (`club`),
  KEY `FKbeiawjws2ou7pvxaa8mk3jc9u` (`tournament`),
  CONSTRAINT `FK3hw08yl5tfk17dqfjo410plns` FOREIGN KEY (`club`) REFERENCES `clubs` (`id`),
  CONSTRAINT `FKbeiawjws2ou7pvxaa8mk3jc9u` FOREIGN KEY (`tournament`) REFERENCES `tournament` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `match` (
  `id` bigint(20) NOT NULL,
  `date` date NOT NULL,
  `drawCoeffficient` float NOT NULL,
  `finished` bit(1) NOT NULL,
  `guestClubWinCoefficient` float NOT NULL,
  `homeClubWinCoefficient` float NOT NULL,
  `popularity` bigint(20) NOT NULL,
  `guestClub` bigint(20) DEFAULT NULL,
  `homeClub` bigint(20) DEFAULT NULL,
  `tournament` bigint(20) DEFAULT NULL,
  `guestGoals` bigint(20) DEFAULT NULL,
  `homeGoals` bigint(20) DEFAULT NULL,
  `result` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoj5uv3h4s8ps0aegvoe79xp2` (`guestClub`),
  KEY `FKgktb315ju811495h4hw6a2k9y` (`homeClub`),
  KEY `FKrqio92kftf2on70k9yirvt45i` (`tournament`),
  CONSTRAINT `FKgktb315ju811495h4hw6a2k9y` FOREIGN KEY (`homeClub`) REFERENCES `clubs` (`id`),
  CONSTRAINT `FKoj5uv3h4s8ps0aegvoe79xp2` FOREIGN KEY (`guestClub`) REFERENCES `clubs` (`id`),
  CONSTRAINT `FKrqio92kftf2on70k9yirvt45i` FOREIGN KEY (`tournament`) REFERENCES `tournament` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `bet` (
  `id` bigint(20) NOT NULL,
  `amount` float NOT NULL,
  `date` date NOT NULL,
  `win` bit(1) NOT NULL,
  `match` bigint(20) DEFAULT NULL,
  `user` bigint(20) DEFAULT NULL,
  `Goal` bigint(20) NOT NULL,
  `winAmount` float DEFAULT NULL,
  `winCoefficient` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdgu6cvdsugpg24g88myax9xua` (`match`),
  KEY `FKcpkll3c7i9i554ctjn7lhmi2i` (`user`),
  CONSTRAINT `FKcpkll3c7i9i554ctjn7lhmi2i` FOREIGN KEY (`user`) REFERENCES `users` (`id`),
  CONSTRAINT `FKdgu6cvdsugpg24g88myax9xua` FOREIGN KEY (`match`) REFERENCES `match` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

