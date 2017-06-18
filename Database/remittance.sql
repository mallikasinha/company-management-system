/*
SQLyog Community Edition- MySQL GUI v6.15
MySQL - 5.0.45-community-nt : Database - remittance
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `remittance`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `company_id` int(11) NOT NULL auto_increment,
  `company_name` varchar(255) default NULL,
  `mailing_address` varchar(255) default NULL,
  `location_address` varchar(255) default NULL,
  `pan_number` varchar(255) default NULL,
  `telephone_no` varchar(255) default NULL,
  `email_address` varchar(255) default NULL,
  `currency_symbol` varchar(10) default NULL,
  `user_id` int(11) default NULL,
  `financial_year` varchar(11) default NULL,
  `entry_date` timestamp NULL default NULL,
  `password` varchar(255) default NULL,
  PRIMARY KEY  (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `company` */

insert  into `company`(`company_id`,`company_name`,`mailing_address`,`location_address`,`pan_number`,`telephone_no`,`email_address`,`currency_symbol`,`user_id`,`financial_year`,`entry_date`,`password`) values (1,'h','h','h','h','h','h@g.com','Rs',5,'72/73','2016-08-27 20:43:35','6f8f57715090da2632453988d9a1501b');

/*Table structure for table `financial_year` */

DROP TABLE IF EXISTS `financial_year`;

CREATE TABLE `financial_year` (
  `id` int(11) NOT NULL auto_increment,
  `financial_year` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

/*Data for the table `financial_year` */

insert  into `financial_year`(`id`,`financial_year`) values (1,'72/73');

/*Table structure for table `income_expense` */

DROP TABLE IF EXISTS `income_expense`;

CREATE TABLE `income_expense` (
  `income_expense_id` int(11) NOT NULL auto_increment,
  `transaction_id` int(11) default NULL,
  `vouchar_number` int(11) default NULL,
  `types` varchar(255) default NULL,
  `payment_method` varchar(255) default NULL,
  PRIMARY KEY  (`income_expense_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `income_expense` */

/*Table structure for table `income_expense_header_field` */

DROP TABLE IF EXISTS `income_expense_header_field`;

CREATE TABLE `income_expense_header_field` (
  `id` int(11) NOT NULL auto_increment,
  `vno` varchar(50) default NULL,
  `income` varchar(50) default NULL,
  `expense` varchar(50) default NULL,
  `payment_mode` varchar(50) default NULL,
  `date_Ad` date default NULL,
  `date_Bs` varchar(50) default NULL,
  `company_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `financial_year` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `income_expense_header_field` */

/*Table structure for table `income_expense_vouchar_entry_table` */

DROP TABLE IF EXISTS `income_expense_vouchar_entry_table`;

CREATE TABLE `income_expense_vouchar_entry_table` (
  `id` int(11) NOT NULL auto_increment,
  `income_expense_header_id` int(11) default NULL,
  `particular` varchar(50) default NULL,
  `amount` float default NULL,
  `naration` text,
  `company_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `financial_year` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `income_expense_vouchar_entry_table` */

/*Table structure for table `journal_entry_header` */

DROP TABLE IF EXISTS `journal_entry_header`;

CREATE TABLE `journal_entry_header` (
  `id` int(11) NOT NULL auto_increment,
  `vouchar_entry` varchar(255) default NULL,
  `date_ad` date default NULL,
  `date_bs` varchar(50) default NULL,
  `user_id` int(11) default NULL,
  `company_id` int(11) default NULL,
  `financial_year` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `journal_entry_header` */

/*Table structure for table `journal_entry_table` */

DROP TABLE IF EXISTS `journal_entry_table`;

CREATE TABLE `journal_entry_table` (
  `id` int(11) NOT NULL auto_increment,
  `journal_entry_header_id` int(11) default NULL,
  `particular` varchar(255) default NULL,
  `dr_amount` float default NULL,
  `cr_amount` float default NULL,
  `narration` varchar(255) default NULL,
  `user_id` int(11) default NULL,
  `company_id` int(11) default NULL,
  `financial_year` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `journal_entry_table` */

/*Table structure for table `ledger` */

DROP TABLE IF EXISTS `ledger`;

CREATE TABLE `ledger` (
  `id` int(11) NOT NULL auto_increment,
  `ledger_id` int(11) default NULL,
  `date_ad` date default NULL,
  `date_bs` varchar(50) default NULL,
  `particular` varchar(255) default NULL,
  `lf_no` varchar(255) default NULL,
  `vouchar_no` varchar(255) default NULL,
  `dr` float default NULL,
  `cr` float default NULL,
  `balance` float default NULL,
  `dr_cr` varchar(5) default NULL,
  `company_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `financial_year` varchar(50) default NULL,
  `entry_date` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `ledger` */

/*Table structure for table `ledger_affect` */

DROP TABLE IF EXISTS `ledger_affect`;

CREATE TABLE `ledger_affect` (
  `affectId` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`affectId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `ledger_affect` */

insert  into `ledger_affect`(`affectId`,`name`) values (1,'Trial Balance'),(2,'Trading A/c'),(3,'PL A/c'),(4,'Balance Sheet'),(5,'Income Statement'),(6,'Cash Flow/Funds flow');

/*Table structure for table `ledger_group_affect` */

DROP TABLE IF EXISTS `ledger_group_affect`;

CREATE TABLE `ledger_group_affect` (
  `id` int(11) NOT NULL auto_increment,
  `ledger_id` int(11) default NULL,
  `affect_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=latin1;

/*Data for the table `ledger_group_affect` */

insert  into `ledger_group_affect`(`id`,`ledger_id`,`affect_id`) values (1,1,1),(2,1,4),(3,2,1),(4,2,4),(5,3,1),(6,3,4),(7,4,1),(8,4,4),(9,5,1),(10,5,4),(11,6,1),(12,6,4),(13,7,1),(14,7,4),(15,7,5),(16,7,6),(17,8,1),(18,8,4),(19,9,1),(20,9,4),(21,10,1),(22,10,2),(23,10,3),(24,10,4),(25,10,5),(26,11,1),(27,11,2),(28,11,3),(29,11,4),(30,11,5),(31,12,1),(32,12,2),(33,12,3),(34,12,4),(35,12,5),(36,13,1),(37,13,4),(38,14,1),(39,14,2),(40,14,3),(41,14,4),(42,14,5),(43,15,1),(44,15,2),(45,15,3),(46,15,4),(47,15,5),(48,16,1),(49,16,4),(50,16,5),(51,16,6),(52,17,1),(53,17,4),(54,18,1),(55,18,4),(56,19,1),(57,19,3),(58,19,4),(59,20,1),(60,20,2),(61,20,3),(62,21,1),(63,21,2),(64,21,3),(65,22,4),(66,23,4),(67,24,3),(68,24,5),(69,25,3),(70,25,5),(71,26,3),(72,26,5),(73,27,3),(74,27,5),(75,28,3),(76,28,5),(77,29,3),(78,29,5),(79,30,4),(80,30,6),(81,31,4),(82,31,6),(83,32,4),(84,32,6),(85,33,4),(86,33,6),(87,34,4),(88,34,6),(89,24,3),(90,24,5),(91,25,2),(92,25,5),(93,26,2),(94,26,5),(95,27,4),(96,27,6),(97,28,4),(98,28,6),(99,29,1),(100,29,2),(101,29,3),(102,29,4),(103,30,1),(104,30,2),(105,30,3),(106,30,4);

/*Table structure for table `ledger_group_name` */

DROP TABLE IF EXISTS `ledger_group_name`;

CREATE TABLE `ledger_group_name` (
  `ledger_group_id` int(11) NOT NULL auto_increment,
  `ledger_group_name` varchar(255) default NULL,
  `company_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `financial_year_from` date default NULL,
  PRIMARY KEY  (`ledger_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

/*Data for the table `ledger_group_name` */

insert  into `ledger_group_name`(`ledger_group_id`,`ledger_group_name`,`company_id`,`user_id`,`financial_year_from`) values (1,'Account Payable',0,0,NULL),(2,'Account Receivable',0,0,NULL),(3,'Bank Account',0,0,NULL),(4,'Bank Occ Account',0,0,NULL),(5,'Bank OD Account',0,0,NULL),(6,'Capital A/c',0,0,NULL),(7,'Cash in Hand',0,0,NULL),(8,'Current Assets',0,0,NULL),(9,'Current Liabilities',0,0,NULL),(10,'Direct Expenses',0,0,NULL),(11,'Direct Income',0,0,NULL),(12,'Duties and Tax',0,0,NULL),(13,'Fix Assets',0,0,NULL),(14,'Indirect Expenses',0,0,NULL),(15,'Indirect Income',0,0,NULL),(16,'Investment',0,0,NULL),(17,'Loan and Advance',0,0,NULL),(18,'Loans',0,0,NULL),(19,'Provision',0,0,NULL),(20,'Purchase',0,0,NULL),(21,'Sales',0,0,NULL);

/*Table structure for table `ledger_info` */

DROP TABLE IF EXISTS `ledger_info`;

CREATE TABLE `ledger_info` (
  `ledger_id` int(11) NOT NULL auto_increment,
  `ledger_name` varchar(255) default NULL,
  `ledgergroup_id` int(11) default NULL,
  `name` varchar(255) default NULL,
  `address` varchar(255) default NULL,
  `pan` varchar(100) default NULL,
  `company_id` int(11) default NULL,
  `financial_year` varchar(50) default NULL,
  `user_id` int(11) default NULL,
  PRIMARY KEY  (`ledger_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `ledger_info` */

insert  into `ledger_info`(`ledger_id`,`ledger_name`,`ledgergroup_id`,`name`,`address`,`pan`,`company_id`,`financial_year`,`user_id`) values (1,'Interest A/C',15,'','','',0,NULL,0),(2,'Delay Charge',15,'','','',0,NULL,0);

/*Table structure for table `loan_amortization` */

DROP TABLE IF EXISTS `loan_amortization`;

CREATE TABLE `loan_amortization` (
  `loan_amortization_id` int(11) NOT NULL auto_increment,
  `loan_amortization_header_id` int(11) default NULL,
  `target_date_ad` date default NULL,
  `target_date_bs` varchar(50) default NULL,
  `loan_amount` float default NULL,
  `payment` float default NULL,
  `interest` float default NULL,
  `principal_amount` float default NULL,
  `ending_balance` float default NULL,
  `user_id` int(11) default NULL,
  `company_id` int(11) default NULL,
  `financial_year` varchar(50) default NULL,
  `paying_status` tinyint(4) default '0',
  PRIMARY KEY  (`loan_amortization_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `loan_amortization` */

/*Table structure for table `loan_amortization_header` */

DROP TABLE IF EXISTS `loan_amortization_header`;

CREATE TABLE `loan_amortization_header` (
  `header_id` int(11) NOT NULL auto_increment,
  `date_ad` date default NULL,
  `date_bs` varchar(50) default NULL,
  `loan_amount` float default NULL,
  `interest_rate` float default NULL,
  `loan_period_in_year` int(3) default NULL,
  `no_of_payment_per_year` int(3) default NULL,
  `ledger_id` int(11) default NULL,
  `company_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `financial_year` varchar(50) default NULL,
  `insert_date` datetime default NULL,
  `paying_status` tinyint(4) default '0',
  PRIMARY KEY  (`header_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `loan_amortization_header` */

/*Table structure for table `remit` */

DROP TABLE IF EXISTS `remit`;

CREATE TABLE `remit` (
  `remit_id` int(11) NOT NULL auto_increment,
  `remit_name` varchar(255) default NULL,
  `company_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  PRIMARY KEY  (`remit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `remit` */

/*Table structure for table `remit_ledger` */

DROP TABLE IF EXISTS `remit_ledger`;

CREATE TABLE `remit_ledger` (
  `remit_ledger_id` int(11) NOT NULL auto_increment,
  `remit_id` int(11) default NULL,
  `date_ad` varchar(255) default NULL,
  `date_bs` varchar(255) default NULL,
  `particular` text,
  `lfno` varchar(255) default NULL,
  `vno` varchar(255) default NULL,
  `control_id` varchar(255) default NULL,
  `dramount` float default NULL,
  `cramount` float default NULL,
  `balance` float default NULL,
  `company_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `financial_year` varchar(50) default NULL,
  `insert_date` datetime default NULL,
  PRIMARY KEY  (`remit_ledger_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `remit_ledger` */

/*Table structure for table `remit_receipt_entry` */

DROP TABLE IF EXISTS `remit_receipt_entry`;

CREATE TABLE `remit_receipt_entry` (
  `id` int(11) NOT NULL auto_increment,
  `vouchar_number` varchar(50) default NULL,
  `date_ad` varchar(50) default NULL,
  `date_bs` varchar(50) default NULL,
  `type` varchar(50) default NULL,
  `remit_id` int(11) default NULL,
  `ledger_id` varchar(255) default NULL,
  `payment_type` varchar(50) default NULL,
  `company_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `financial_year` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `remit_receipt_entry` */

/*Table structure for table `remit_receipt_entry_table` */

DROP TABLE IF EXISTS `remit_receipt_entry_table`;

CREATE TABLE `remit_receipt_entry_table` (
  `id` int(11) NOT NULL auto_increment,
  `remit_header_id` int(11) default NULL,
  `client_name` varchar(255) default NULL,
  `location` varchar(255) default NULL,
  `id_proof` varchar(255) default NULL,
  `remit_id` varchar(255) default NULL,
  `amount` float default NULL,
  `commission` float default NULL,
  `total` float default NULL,
  `company_id` int(11) default NULL,
  `user_id` int(11) default NULL,
  `financial_year` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `remit_receipt_entry_table` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  `username` varchar(11) default NULL,
  `password` varchar(255) default NULL,
  `role` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`username`,`password`,`role`) values (1,'mallika','mallika','mallika','admin'),(2,NULL,'superadmin','MD5(superadmin)','superadmin'),(5,'admin','admin','21232f297a57a5a743894a0e4a801fc3','admin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
