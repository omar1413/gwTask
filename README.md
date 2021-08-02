use maven for build

make sure changing the application.properties file with the correct database configuration

import gwTask.json in postman for test the end points

sql scripts :


    CREATE TABLE `gateway` (
    `id` bigint NOT NULL,
    `ip_address` varchar(255) DEFAULT NULL,
    `name` varchar(255) DEFAULT NULL,
    `serial_number` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
    )

    CREATE TABLE `peripheral` (
    `id` bigint NOT NULL,
    `uid` bigint DEFAULT NULL,
    `created_date` datetime DEFAULT NULL,
    `gateway_id` bigint DEFAULT NULL,
    `online_status` bit(1) DEFAULT NULL,
    `vendor` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK5jmmc4fnfkoqnmn8uxjwnemqr` (`gateway_id`)
    )

