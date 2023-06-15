DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS is_active;
DROP TABLE IF EXISTS pay_rate;
DROP TABLE IF EXISTS punch_time;
DROP TABLE IF EXISTS request_time_off;
DROP TABLE IF EXISTS shift_assignment;
DROP TABLE IF EXISTS time_sheet;
DROP TABLE IF EXISTS working_time;


CREATE TABLE employees
(
    id         SERIAL PRIMARY KEY   NOT NULL,
    email      TEXT UNIQUE          NOT NULL,
    password   TEXT                 NOT NULL,
    enabled    BOOLEAN DEFAULT TRUE NOT NULL,
    first_name TEXT,
    last_name  TEXT,
    role       TEXT
);

CREATE TABLE is_active
(
    id          SERIAL PRIMARY KEY   NOT NULL,
    employee_id INTEGER UNIQUE     NOT NULL,
    is_active   BOOLEAN
);

CREATE TABLE time_sheet
(
    id          SERIAL PRIMARY KEY   NOT NULL,
    employee_id INTEGER          NOT NULL,
    total_working_time NUMERIC     NOT NULL
);

CREATE TABLE pay_rate
(
    id          SERIAL PRIMARY KEY   NOT NULL,
    employee_id INTEGER     NOT NULL,
    pay_rate    NUMERIC     NOT NULL,
    over_pay_rate NUMERIC     NOT NULL
);

CREATE TABLE punch_time
(
    id          SERIAL PRIMARY KEY   NOT NULL,
    employee_id INTEGER            NOT NULL,
    punch_time  TIMESTAMP          NOT NULL,
    in_out_or_break TEXT           NOT NULL
);

CREATE TABLE working_time
(
    id          SERIAL PRIMARY KEY   NOT NULL,
    employee_id INTEGER          NOT NULL,
    working_time NUMERIC     NOT NULL
);

CREATE TABLE request_time_off
(
    id          SERIAL PRIMARY KEY   NOT NULL,
    employee_id INTEGER        NOT NULL,
    start_time  TIMESTAMP          NOT NULL,
    end_time    TIMESTAMP      NOT NULL
);

CREATE TABLE shift_assignment
(
    id          SERIAL PRIMARY KEY   NOT NULL,
    employee_id INTEGER       NOT NULL,
    start_time  TIMESTAMP          NOT NULL,
    end_time    TIMESTAMP      NOT NULL
);








