/*
SQLyog Community v13.1.2 (32 bit)
MySQL - 5.5.41 : Database - flight_tic
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`flight_tic` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `flight_tic`;

/*Table structure for table `admincred` */

DROP TABLE IF EXISTS `admincred`;

CREATE TABLE `admincred` (
  `adminid` varchar(25) NOT NULL,
  `password` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admincred` */

insert  into `admincred`(`adminid`,`password`) values 
('Admin@cranes','Admin@123');

/*Table structure for table `booking` */

DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking` (
  `c_id` int(5) NOT NULL,
  `f_id` int(5) NOT NULL,
  `c_name` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `source` varchar(25) NOT NULL,
  `destination` varchar(25) NOT NULL,
  `dept_time` time NOT NULL,
  `arrival_time` time NOT NULL,
  `date_of_dept` date NOT NULL,
  `price` int(10) NOT NULL,
  `f_name` varchar(25) DEFAULT NULL,
  KEY `c_id` (`c_id`),
  KEY `f_id` (`f_id`),
  CONSTRAINT `c_id` FOREIGN KEY (`c_id`) REFERENCES `customer` (`C_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `f_id` FOREIGN KEY (`f_id`) REFERENCES `flight_schedule` (`f_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `booking` */

insert  into `booking`(`c_id`,`f_id`,`c_name`,`email`,`source`,`destination`,`dept_time`,`arrival_time`,`date_of_dept`,`price`,`f_name`) values 
(105,1005,'sajid','sajid@yahoo.in','BANGALORE','HYDERABAD','07:30:00','09:30:00','2023-12-02',2500,'VISTARA'),
(105,1008,'sajid','sajid@yahoo.in','MUMBAI','DELHI','06:30:00','08:55:00','2023-12-03',3000,'VISTARA'),
(111,1008,'Adnan','adnanshariff.9@gmail.com','MUMBAI','DELHI','06:30:00','08:55:00','2023-12-03',3000,'VISTARA'),
(111,1002,'Adnan','adnanshariff.9@gmail.com','BANGALORE','DELHI','09:30:00','12:30:00','2023-11-30',4000,'INDIGO'),
(108,1002,'khabib','khabib@yahoo.ru','BANGALORE','DELHI','09:30:00','12:30:00','2023-11-30',4000,'INDIGO');

/*Table structure for table `customer` */

DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
  `C_id` int(5) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `ph_no` bigint(10) NOT NULL,
  PRIMARY KEY (`C_id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=latin1;

/*Data for the table `customer` */

insert  into `customer`(`C_id`,`c_name`,`email`,`password`,`ph_no`) values 
(104,'maaz','maaz@gmail.com','Maaz@123',123456789),
(105,'sajid','sajid@yahoo.in','Sajid@123',7894563210),
(106,'hassan','hassan@hotmail.com','Hassan@123',4561230987),
(107,'Raju','raju@gmail.com','Raju@!23',7410852369),
(108,'khabib','khabib@yahoo.ru','Khabib@123',7410852369),
(109,'kholi','kholi@gmail.com','Kholi@123',7534210869),
(110,'Dhoni','msd@gmail.com','Dhoni@123',123444789),
(111,'Adnan','adnanshariff.9@gmail.com','Adnan@!23',8431193501);

/*Table structure for table `flight_schedule` */

DROP TABLE IF EXISTS `flight_schedule`;

CREATE TABLE `flight_schedule` (
  `f_id` int(5) NOT NULL AUTO_INCREMENT,
  `f_name` varchar(25) DEFAULT NULL,
  `source` varchar(25) DEFAULT NULL,
  `destination` varchar(25) DEFAULT NULL,
  `dept_time` time DEFAULT NULL,
  `arrival_time` time DEFAULT NULL,
  `date_of_dept` date DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  PRIMARY KEY (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1010 DEFAULT CHARSET=latin1;

/*Data for the table `flight_schedule` */

insert  into `flight_schedule`(`f_id`,`f_name`,`source`,`destination`,`dept_time`,`arrival_time`,`date_of_dept`,`price`) values 
(1001,'AIRINDIA','BANGALORE','DELHI','12:20:00','15:20:00','2023-11-30',4500),
(1002,'INDIGO','BANGALORE','DELHI','09:30:00','12:30:00','2023-11-30',4000),
(1005,'VISTARA','BANGALORE','HYDERABAD','07:30:00','09:30:00','2023-12-02',2500),
(1006,'AIRINDIA','HYDERABAD','BANGALORE','01:16:00','02:16:00','2023-12-02',2800),
(1007,'VISTARA','HYDERABAD','CHENNAI','01:25:00','02:25:00','2023-12-02',2500),
(1008,'VISTARA','MUMBAI','DELHI','06:30:00','08:55:00','2023-12-03',3000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
