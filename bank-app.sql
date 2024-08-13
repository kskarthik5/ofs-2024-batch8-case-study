DELIMITER //
DROP DATABASE IF exists BANK_DEV;
CREATE DATABASE BANK_DEV;
USE BANK_DEV;
//
CREATE TABLE CUSTOMERS(
customer_id	integer AUTO_INCREMENT,
CONSTRAINT customer_id_pk PRIMARY KEY (customer_id),
username VARCHAR(50) NOT NULL UNIQUE,
first_name	VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
password	VARCHAR(50) NOT NULL,
attempts	INTEGER,
phone INTEGER NOT NULL,
email	VARCHAR(50),
login_status	VARCHAR(50),
status	VARCHAR(50) DEFAULT 'Active',
profile_picture BLOB
) auto_increment=100001;
//
CREATE TABLE LOGIN_SESSIONS (
	session_id	integer AUTO_INCREMENT,
	CONSTRAINT session_id_pk PRIMARY KEY (session_id),
    start_time timestamp default current_timestamp NOT NULL,
    end_time timestamp GENERATED ALWAYS AS (start_time + INTERVAL 10 MINUTE),
    session_token varchar(100),
    customer_id integer UNIQUE,
    CONSTRAINT session_customer_id_fk FOREIGN KEY(customer_id) REFERENCES Customers(customer_id)
) auto_increment=1;
//
CREATE TABLE ACCOUNTS (
account_id	INTEGER auto_increment,
customer_id	INTEGER,
account_type	VARCHAR(50),
balance	DOUBLE DEFAULT 0,
min_balance	DOUBLE,
rate_of_interest FLOAT,
interest_period INT,
interest_date DATE,
status	VARCHAR(50) DEFAULT 'Active',
CONSTRAINT account_id_pk PRIMARY KEY(account_id),
CONSTRAINT account_customer_id_fk FOREIGN KEY(customer_id) REFERENCES CUSTOMERS(customer_id)
) auto_increment=100001;
//
CREATE TABLE TRANSACTIONS(
transaction_id INTEGER auto_increment,
payer_id	INTEGER NOT NULL,
payee_id	INTEGER NOT NULL,
amount	INTEGER NOT NULL,
CONSTRAINT transaction_id_pk PRIMARY KEY(transaction_id),
CONSTRAINT payer_id_pk FOREIGN KEY(payer_id) REFERENCES ACCOUNTS(account_id),
CONSTRAINT payee_id_pk FOREIGN KEY(payee_id) REFERENCES ACCOUNTS(account_id),
timestamp	TIMESTAMP default CURRENT_TIMESTAMP
) auto_increment=1000000001;
//
CREATE TABLE BANK_SLIPS	(
slip_id	INTEGER,
account_id	INTEGER,
status	VARCHAR(40),
CONSTRAINT slip_account_id_fk FOREIGN KEY(account_id) REFERENCES ACCOUNTS(account_id),
CONSTRAINT slip_id_pk PRIMARY KEY (slip_id)
);
//
CREATE TABLE CHEQUES(
account_id	INTEGER NOT NULL,
cheque_id	INTEGER  auto_increment,
status	VARCHAR(50),
amount INTEGER,
payee_name VARCHAR(50),
slip_id	INTEGER,
CONSTRAINT cheque_id_pk PRIMARY KEY(cheque_id),
CONSTRAINT cheque_account_id_fk FOREIGN KEY(account_id) REFERENCES ACCOUNTS(account_id),
CONSTRAINT slip_id_fk FOREIGN KEY(slip_id) REFERENCES BANK_SLIPS(slip_id)
) auto_increment=10000001;
//
CREATE TABLE SCHEMES (
scheme_id	INTEGER  auto_increment,
scheme_name	VARCHAR(50) UNIQUE,
rate_of_interest	FLOAT,
min_balance	DOUBLE,
interest_period INT,
constraint scheme_id_pk PRIMARY KEY (scheme_id)
);
//
INSERT INTO SCHEMES (scheme_name,rate_of_interest,min_balance,interest_period) VALUES ('Savings',3.4,5000,365);
INSERT INTO SCHEMES (scheme_name,rate_of_interest,min_balance,interest_period) VALUES ('Current',0,-10000,0);
INSERT INTO SCHEMES (scheme_name,rate_of_interest,min_balance,interest_period) VALUES ('FixedDeposit',7.6,0,444);
//
CREATE TABLE ADMINS (
username VARCHAR(50),
password VARCHAR(50),
CONSTRAINT admin_username_pk PRIMARY KEY(username)
);
//
INSERT INTO CUSTOMERS (username, first_name, last_name, password, attempts, phone, email, login_status, status) VALUES
('jdoe', 'John', 'Doe', 'password123', 0, 123478901, 'jdoe@example.com', 'active', 'active');
INSERT INTO CUSTOMERS (username, first_name, last_name, password, attempts, phone, email, login_status, status) VALUES
('asmith', 'Alice', 'Smith', 'mypassword', 1, 125678902, 'asmith@example.com', 'active', 'active');
INSERT INTO CUSTOMERS (username, first_name, last_name, password, attempts, phone, email, login_status, status) VALUES
('bwilliams', 'Bob', 'Williams', 'securepass', 2, 125678903, 'bwilliams@example.com', 'inactive', 'inactive');
INSERT INTO CUSTOMERS (username, first_name, last_name, password, attempts, phone, email, login_status, status) VALUES
('cjohnson', 'Carol', 'Johnson', 'pass456', 0, 123478904, 'cjohnson@example.com', 'active', 'active');
INSERT INTO CUSTOMERS (username, first_name, last_name, password, attempts, phone, email, login_status, status) VALUES
('dwhite', 'David', 'White', 'pass1234', 1, 123458905, 'dwhite@example.com', 'inactive', 'active');
INSERT INTO CUSTOMERS (username, first_name, last_name, password, attempts, phone, email, login_status, status) VALUES
('emartinez', 'Eva', 'Martinez', '12345pass', 3, 123478906, 'emartinez@example.com', 'active', 'inactive');
INSERT INTO CUSTOMERS (username, first_name, last_name, password, attempts, phone, email, login_status, status) VALUES
('fgarcia', 'Frank', 'Garcia', 'pass678', 0, 123478907, 'fgarcia@example.com', 'active', 'active');
INSERT INTO CUSTOMERS (username, first_name, last_name, password, attempts, phone, email, login_status, status) VALUES
('gchen', 'Grace', 'Chen', 'password!', 0, 123458908, 'gchen@example.com', 'inactive', 'active');
INSERT INTO CUSTOMERS (username, first_name, last_name, password, attempts, phone, email, login_status, status) VALUES
('hlopez', 'Hugo', 'Lopez', 'mysecret', 2, 123458909, 'hlopez@example.com', 'active', 'inactive');
INSERT INTO CUSTOMERS (username, first_name, last_name, password, attempts, phone, email, login_status, status) VALUES
('ijones', 'Ivy', 'Jones', 'letmein', 1, 123478910, 'ijones@example.com', 'active', 'active');
//
CREATE PROCEDURE p_create_account(IN p_customer_id integer, IN p_type varchar(50),OUT o_status integer,OUT o_message varchar(50))
BEGIN
	declare v_min_balance double;
	declare v_rate_of_interest float;
	declare v_interest_period integer;
	DECLARE EXIT HANDLER FOR NOT FOUND
	BEGIN
		SET o_status=-1;
        SET o_message='SCHEME NOT FOUND';
    END;

    SELECT min_balance,rate_of_interest,interest_period into v_min_balance,v_rate_of_interest,v_interest_period from SCHEMES where scheme_name=p_type;
    INSERT INTO ACCOUNTS (customer_id,account_type,min_balance,rate_of_interest,interest_period,interest_date) VALUES (p_customer_id,p_type,v_min_balance,v_rate_of_interest,v_interest_period,DATE_ADD(CURRENT_DATE(),INTERVAL v_interest_period DAY));
	SET o_status=1;
	SET o_message='OK';
END
//
CREATE PROCEDURE p_generate_cheques (IN p_account_id integer, IN count integer)
p:BEGIN
	declare i integer;
	declare v_account_type varchar(50);
    set i=0;
    SELECT account_type into v_account_type FROM accounts where account_id=p_account_id;
    if v_account_type = 'FixedDeposit' then
		leave p;
    end if;
    iloop:LOOP
		INSERT INTO CHEQUES (account_id) VALUES(p_account_id);
		set i=i+1;
        IF i = count then
			LEAVE iloop;
		END IF;
	END LOOP;
END;
//
CREATE PROCEDURE p_admin_check(in p_username varchar(50),in p_password varchar(50))
BEGIN
	declare v_password varchar(50);
    SELECT password INTO v_password from ADMINS where username=p_username;
    IF v_password = p_password THEN
		SELECT 1;
	ELSE
		SELECT 0;
	END IF;
END
//
CREATE TRIGGER t_generate_chqs_on_new_acc
AFTER INSERT ON ACCOUNTS
FOR EACH ROW
BEGIN
    CALL p_generate_cheques(new.account_id,10);
END;
//
CREATE PROCEDURE p_login_check (IN p_username varchar(50), IN p_password varchar(50),OUT o_status integer,OUT o_message varchar(50))
BEGIN
    declare v_password varchar(50);
	declare v_status varchar(50);
    declare v_login_status varchar(50);
    declare v_attempts varchar(50);
	DECLARE EXIT HANDLER FOR NOT FOUND
	BEGIN
		SET o_status=-1;
        SET o_message='NOT FOUND';
    END;
	SELECT login_status,password,attempts,status INTO v_login_status,v_password,v_attempts,v_status FROM customers WHERE username = p_username;
    IF	v_status = 'inactive' THEN
		set o_message='NOT ACTIVATED';
		set o_status=0;
    ELSEIF v_login_status = 'locked' THEN
		set o_message='LOCKED';
        set o_status=0;
    ELSEIF v_password = p_password THEN
        set o_message='OK'; 
        set o_status=1;
        UPDATE customers set attempts=3 WHERE username=p_username;
    ELSE
        UPDATE customers set attempts=attempts-1 WHERE username=p_username;
        IF v_attempts < 2 THEN
             UPDATE customers set login_status='locked' WHERE username=p_username;
        END IF;
        set o_message='INCORRECT';
        set o_status=0;
    END IF;
END;
//
CREATE PROCEDURE p_deposit(IN p_account_id INTEGER,IN p_amount DOUBLE,OUT o_status INTEGER,OUT o_message varchar(50))
p:BEGIN
	declare v_status VARCHAR(50);
    declare v_account_type VARCHAR(50);
	SELECT status,account_type into v_status,v_account_type FROM accounts where account_id=p_account_id;
    if(v_status = 'locked') THEN
        SET o_status=0;
        SET o_message='DEPOSIT LOCKED';
    elseif(v_account_type = 'FixedDeposit') THEN
		UPDATE Accounts SET balance=p_amount, status='locked' where account_id=p_account_id;
        SET o_status=1;
        SET o_message='OK';
	else
    	UPDATE Accounts SET balance=balance+p_amount where account_id=p_account_id;
		SET o_message='OK';
        SET o_status=1;
    end if;
END
//
CREATE PROCEDURE p_withdraw(IN p_account_id INTEGER,IN p_amount DOUBLE,OUT o_status INTEGER,OUT o_message VARCHAR(50))
p:BEGIN
	declare v_status VARCHAR(50);
    declare v_account_type VARCHAR(50);
    declare v_balance DOUBLE;
	declare v_min_balance DOUBLE;
	SELECT status,account_type,balance,min_balance into v_status,v_account_type,v_balance,v_min_balance FROM accounts where account_id=p_account_id;
    if(v_status = 'locked') THEN
		SET o_status=0;
		SET o_message='WITHDRAW LOCKED';
	else
		IF(v_min_balance>=0) THEN
			if(v_balance-p_amount >= 0) THEN
				UPDATE Accounts SET balance=balance-p_amount where account_id=p_account_id;
                SET o_message='OK';
                SET o_status=1;
			else
				SET o_status=0;
				SET o_message='INSUFFIENT BALANCE';
            END IF;
		else
			if(v_balance-p_amount>=v_min_balance) then
				UPDATE Accounts SET balance=balance-p_amount where account_id=p_account_id;
                IF v_balance-p_amount<0 then
					SET o_message='OK OVERDRAFT';
                    SET o_status=1;
				ELSE
					SET o_message='OK';
                    SET o_status=1;
				END if;
            else
				SET o_status=0;
				SET o_message='INSUFFICIENT OVERDRAFT BALANCE';
            end if;
        END IF;
    end if;
END
//
CREATE PROCEDURE p_transfer(IN p_payer integer,IN p_payee integer,IN p_amount integer,OUT p_status integer,OUT p_message varchar(50))
BEGIN
	declare v_status integer;
	declare v_message varchar(50);
	START TRANSACTION;
    CALL p_withdraw(p_payer,p_amount,v_status,v_message);
    if(v_status = 1) then
		CALL p_deposit(p_payee,p_amount,v_status,v_message);
        if(v_status = 1) then
			SET p_status = 1;
            SET p_message = 'OK';
			COMMIT;
		else
			SET p_status = 0;
            SET p_message = v_message;
			ROLLBACK;
		end if;
	ELSE
		SET p_status = 0;
		SET p_message = v_message;
		ROLLBACK;
    END IF;
END
//
INSERT into Admins VALUES ('ksk','123');
call p_create_account(100001,'Current',@stat,@mes);
call p_create_account(100001,'Savings',@stat,@mes);
call p_create_account(100001,'FixedDeposit',@stat,@mes);
call p_deposit(100001,7000,@stat,@mes);
call p_withdraw(100001,7000,@stat,@mes);		
call p_transfer(100002,100003,9000,@stat,@mes);
call p_login_check('jdoe','password123',@stat,@mes);
SELECT @stat,@mes
