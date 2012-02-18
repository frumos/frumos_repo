DROP TABLE IF EXISTS message_keycode;
DROP TABLE IF EXISTS keycodes;
DROP TABLE IF EXISTS messages;
DROP TABLE IF EXISTS categories;

CREATE TABLE categories (
    id INTEGER AUTO_INCREMENT NOT NULL,
    name VARCHAR(16) NOT NULL UNIQUE,
    PRIMARY KEY( id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE keycodes (
    id  INTEGER AUTO_INCREMENT NOT NULL,    
    keycode  VARCHAR(24) NOT NULL,
    PRIMARY KEY( id )    
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE smi_replay_categories (
    id INTEGER AUTO_INCREMENT NOT NULL,
    name VARCHAR(16) NOT NULL UNIQUE,
    PRIMARY KEY( id )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE messages (
    id  INTEGER AUTO_INCREMENT NOT NULL,  
    category_f_id INTEGER NOT NULL,
    url VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    PRIMARY KEY( id ), 
    CONSTRAINT category_fk_constraint FOREIGN KEY (category_f_id) REFERENCES categories (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE message_keycode (
  id int(11) NOT NULL auto_increment,
  keycode_f_id int(11) NOT NULL,
  message_f_id int(11) NOT NULL,
  created_date timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY  (id),
  CONSTRAINT keycode_fk_constraint FOREIGN KEY (keycode_f_id) REFERENCES keycodes (id) ON UPDATE CASCADE ON DELETE CASCADE,
  CONSTRAINT fk_constraint FOREIGN KEY (message_f_id) REFERENCES messages (id) ON UPDATE CASCADE ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;