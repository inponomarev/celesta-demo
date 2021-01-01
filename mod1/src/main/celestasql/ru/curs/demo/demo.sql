CREATE GRAIN demo VERSION '1.0';

-- *** TABLES ***
/**Заголовок счёта*/
CREATE TABLE OrderHeader(
  ss INT,
  id VARCHAR(30) NOT NULL,
  date DATETIME,
  customer_id VARCHAR(30),

  /**Название клиента */
  customer_name VARCHAR(50),
  manager_id VARCHAR(30),
  CONSTRAINT Pk_OrderHeader PRIMARY KEY (id)
);

/**Purchase Order line*/
CREATE TABLE OrderLine(
  order_id VARCHAR(30) NOT NULL,
  line_no INT NOT NULL,
  description VARCHAR(100),
  item_id VARCHAR(30) NOT NULL,
  item_name VARCHAR(100),
  qty INT NOT NULL DEFAULT 0,
  cost REAL NOT NULL DEFAULT 0.0,
  CONSTRAINT Idx_OrderLine PRIMARY KEY (order_id, line_no)
);

create table aa(
 id int not null primary key,
 value varchar(20)
);

-- *** FOREIGN KEYS ***
ALTER TABLE OrderLine ADD CONSTRAINT fk_OrderLine FOREIGN KEY (order_id) REFERENCES OrderHeader(id);
-- *** INDICES ***

-- *** VIEWS ***
create table ffff (
 a int not null primary key,
 b int
);

create view foo as select line_no from OrderLine;

create function ffunc(p int) as
 select order_id from OrderLine where line_no = $p;

create materialized view OrderedQty as

  select item_id, sum(qty) as qty from OrderLine group by item_id;
-- *** MATERIALIZED VIEWS ***