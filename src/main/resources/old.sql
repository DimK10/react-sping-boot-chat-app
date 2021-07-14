-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: localhost:3306
-- Χρόνος δημιουργίας: 13 Ιουλ 2021 στις 18:53:07
-- Έκδοση διακομιστή: 5.7.33
-- Έκδοση PHP: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `chat-app`
--

--
-- Άδειασμα δεδομένων του πίνακα `conversation`
--



TRUNCATE TABLE `message`;



TRUNCATE TABLE `conversation_users_involved`;


SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE `user`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `user` (`id`, `email`, `firstname`, `lastname`, `username`) VALUES
(1, 'user0@gmail.com', 'John', 'Doe', 'jDoe'),
(2, 'user1@gmail.com', 'Foo', 'Bar', 'fBar');
COMMIT;

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE `conversation`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `conversation` (`id`, `date_time_created`, `date_time_updated`) VALUES
(3, '2021-07-13 21:48:04.630000', '2021-07-13 21:48:04.630000');

--
-- Άδειασμα δεδομένων του πίνακα `conversation_users_involved`
--
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE `conversation_users_involved`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `conversation_users_involved` (`conversation_id`, `users_involved_id`) VALUES
(3, 1),
(3, 2);

--
-- Άδειασμα δεδομένων του πίνακα `message`
--

SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE `message`;
SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `message` (`id`, `date_time_created`, `payload`, `conversation_id`, `user_id`) VALUES
(4, '2021-07-13 21:48:04.630000', 'Hello Foo! How are you?', 3, 1),
(5, '2021-07-13 21:48:04.630000', 'Hello Joe! Im good, you?', 3, 2);

--
-- Άδειασμα δεδομένων του πίνακα `user`
--





/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
