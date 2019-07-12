-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: lib_sys
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `books` (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `book_title` varchar(100) DEFAULT NULL,
  `id_author` int(11) NOT NULL,
  `id_genre` int(11) NOT NULL,
  `book_year` int(11) DEFAULT NULL,
  `book_description` mediumtext,
  `book_picture` varchar(3000) DEFAULT NULL,
  `book_file` mediumblob,
  `book_status` tinyint(4) NOT NULL,
  PRIMARY KEY (`book_id`),
  KEY `fk_Books_Authors_idx` (`id_author`),
  KEY `fk_Books_Genre1_idx` (`id_genre`),
  CONSTRAINT `fk_Books_Authors` FOREIGN KEY (`id_author`) REFERENCES `authors` (`author_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_Books_Genre1` FOREIGN KEY (`id_genre`) REFERENCES `genre` (`genre_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'The Call of Cthulhu',1,1,1928,'\"The Call of Cthulhu\" is a short story by American writer H. P. Lovecraft. Written in the summer of 1926, it was first published in the pulp magazine Weird Tales, in February 1928.','https://upload.wikimedia.org/wikipedia/commons/thumb/a/af/Weird_Tales_February_1928.jpg/150px-Weird_Tales_February_1928.jpg',NULL,1),(3,'The Dream-Quest of Unknown Kadath',1,1,1943,'The Dream-Quest of Unknown Kadath is a novella by American writer H. P. Lovecraft. Begun probably in the autumn of 1926, the draft was completed on January 22, 1927 and it remained unrevised and unpublished in his lifetime. It is both the longest of the stories that make up his Dream Cycle and the longest Lovecraft work to feature protagonist Randolph Carter. Along with his 1927 novel The Case of Charles Dexter Ward, it can be considered one of the significant achievements of that period of Lovecraft\'s writing. The Dream-Quest combines elements of horror and fantasy into an epic tale that illustrates the scope and wonder of humankind\'s ability to dream.\nThe story was published posthumously by Arkham House in 1943.[1] Currently, it is published by Ballantine Books in an anthology that also includes \"The Silver Key\" and \"Through the Gates of the Silver Key.\" The definitive version, with corrected text by S. T. Joshi, is published by Arkham House in At the Mountains of Madness and Other Novels and by Penguin Classics in The Dreams in the Witch-House and Other Weird Stories.','https://upload.wikimedia.org/wikipedia/en/thumb/5/55/The-Dream-Quest-of-Unknown-Kadath.jpg/220px-The-Dream-Quest-of-Unknown-Kadath.jpg',NULL,1),(4,'At the Mountains of Madness',1,1,1936,'At the Mountains of Madness is a science fiction-horror novella by American author H. P. Lovecraft, written in February/March 1931 and rejected that year by Weird Tales editor Farnsworth Wright on the grounds of its length.[1] It was originally serialized in the February, March, and April 1936 issues of Astounding Stories. It has been reproduced in numerous collections.\n\nThe story details the events of a disastrous expedition to the Antarctic continent in September 1930, and what was found there by a group of explorers led by the narrator, Dr. William Dyer of Miskatonic University. Throughout the story, Dyer details a series of previously untold events in the hope of deterring another group of explorers who wish to return to the continent.','https://upload.wikimedia.org/wikipedia/en/thumb/f/fc/Lovecraft%2C_Mountains_of_Madness.jpg/200px-Lovecraft%2C_Mountains_of_Madness.jpg',NULL,1);
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-04 16:56:52
