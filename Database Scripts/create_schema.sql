/* start fresh */
DROP DATABASE IF EXISTS simplyfly;
CREATE DATABASE simplyfly;
USE simplyfly;

/* 1. users */
CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    gender VARCHAR(20),
    contact_number VARCHAR(15),
    address TEXT,
    role ENUM('PASSENGER','FLIGHT_OWNER','ADMIN') NOT NULL,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP
);

/* 2. flights  (aircraft + commercial number) */
CREATE TABLE flights (
    flight_id INT AUTO_INCREMENT PRIMARY KEY,
    owner_id  INT NOT NULL,
    flight_number VARCHAR(20) NOT NULL UNIQUE,
    flight_name   VARCHAR(100),
    total_seats   INT NOT NULL,
    checkin_kg INT DEFAULT 15,
    cabin_kg   INT DEFAULT 7,
    FOREIGN KEY (owner_id) REFERENCES users(user_id)
);

/* 3. routes  (one dated service of a flight) */
CREATE TABLE routes (
    route_id INT AUTO_INCREMENT PRIMARY KEY,
    flight_id INT NOT NULL,
    origin VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    departure_ts DATETIME NOT NULL,
    arrival_ts   DATETIME NOT NULL,
    fare_per_seat DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (flight_id) REFERENCES flights(flight_id)
);

/* 4. seats  (inventory per route) */
CREATE TABLE seats (
    seat_id INT AUTO_INCREMENT PRIMARY KEY,
    route_id INT NOT NULL,
    seat_number VARCHAR(10) NOT NULL,
    class ENUM('ECONOMY','BUSINESS') DEFAULT 'ECONOMY',
    status ENUM('AVAILABLE','BOOKED') DEFAULT 'AVAILABLE',
    FOREIGN KEY (route_id) REFERENCES routes(route_id),
    UNIQUE(route_id, seat_number)           -- seat 1A can repeat on a different route
);

/* 5. bookings  (one order by a passenger) */
CREATE TABLE bookings (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id  INT NOT NULL,
    route_id INT NOT NULL,
    total_amount DECIMAL(10,2) NOT NULL,
    status ENUM('BOOKED','CANCELLED') DEFAULT 'BOOKED',
    booked_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_id)  REFERENCES users(user_id),
    FOREIGN KEY (route_id) REFERENCES routes(route_id)
);

/* 6. booking_seats  (which seats are in the booking) */
CREATE TABLE booking_seats (
    id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT NOT NULL,
    seat_id    INT NOT NULL,
    FOREIGN KEY (booking_id) REFERENCES bookings(booking_id),
    FOREIGN KEY (seat_id)    REFERENCES seats(seat_id),
    UNIQUE(booking_id, seat_id)             -- avoid duplicate seat rows
);

/* 7. payments */
CREATE TABLE payments (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT NOT NULL,
    payment_method ENUM('UPI','CARD','NETBANKING') NOT NULL,
    amount_paid DECIMAL(10,2) NOT NULL,
    payment_status ENUM('FAILED','PAID','PENDING') DEFAULT 'PENDING',
    payment_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (booking_id) REFERENCES bookings(booking_id)
);

/* 8. booking_history  (audit trail) */
CREATE TABLE booking_history (
    history_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT NOT NULL,
    action ENUM('BOOKED','CANCELLED') NOT NULL,
    action_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (booking_id) REFERENCES bookings(booking_id)
);
