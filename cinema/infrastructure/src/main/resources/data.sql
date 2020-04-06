CREATE TABLE IF NOT EXISTS category
(
	category_id int NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	description varchar(5000),
	PRIMARY KEY (category_id)
);

CREATE TABLE IF NOT EXISTS movie
(
	movie_id int NOT NULL AUTO_INCREMENT,
	name varchar(100) NOT NULL,
	description varchar(5000),
	category_id int NOT NULL,
  active boolean NOT NULL,
  deleted boolean NOT NULL,
	PRIMARY KEY (movie_id),
    FOREIGN KEY (category_id) REFERENCES category(category_id)
);

INSERT INTO category (name, description)
VALUES ('Science Fiction', 'is a film genre that uses speculative, fictional science-based depictions of phenomena that are not fully accepted by mainstream science, such as extraterrestrial lifeforms, alien worlds, extrasensory perception and time travel');

INSERT INTO category (name, description)
VALUES ('Action', 'is a film genre in which the protagonist or protagonists are thrust into a series of events that typically include violence, extended fighting, physical feats');

INSERT INTO movie (name, description, category_id, active, deleted)
VALUES('Matrix', 'is a 1999 science fiction action film written and directed by the Wachowskis. It stars Keanu Reeves, Laurence Fishburne, Carrie-Anne Moss, Hugo Weaving, and Joe Pantoliano and is the first installment in the Matrix franchise.', (SELECT category_id FROM category WHERE name = 'Science Fiction'), true, false);