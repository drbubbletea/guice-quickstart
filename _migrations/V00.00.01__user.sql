CREATE TABLE `app_user`
(
    `id`       int(11)      NOT NULL AUTO_INCREMENT,
    `email`    varchar(60)  NOT NULL,
    `password` varchar(60)  NOT NULL,
    `created`  timestamp(6) NOT NULL DEFAULT current_timestamp(6),
    PRIMARY KEY (`id`),
    UNIQUE KEY `unq_user_email` (`email`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci;