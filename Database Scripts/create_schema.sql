create database simplyfly;
use simplyfly;

--  users table 
create table users (
    user_id int primary key auto_increment,
    name varchar(100) not null,
    email varchar(100) unique not null,
    password_hash varchar(255) not null,
    gender varchar(20),
    contact_number varchar(15),
    address text,
    role enum('passenger', 'flight_owner', 'admin') not null,
    created_at datetime default current_timestamp
);

--  routes table
create table routes (
    route_id int primary key auto_increment,
    origin varchar(100) not null unique,
    destination varchar(100) not null unique,
    duration time
);

--  flights table
create table flights (
    flight_id int primary key auto_increment,
    flight_name varchar(100) not null,
    flight_number varchar(20) unique not null,
    route_id int not null,
    departure_time datetime,
    arrival_time datetime,
    total_seats int not null,
    fare_per_seat decimal(10, 2) not null,
    owner_id int not null,
    foreign key (route_id) references routes(route_id),
    foreign key (owner_id) references users(user_id)
);

--  baggage_info table
create table baggage_info (
    baggage_id int primary key auto_increment,
    flight_id int,
    checkin_weight_per_adult_kg int,
    cabin_weight_per_adult_kg int,
    foreign key (flight_id) references flights(flight_id)
);

-- seats table
create table seats (
    seat_id int primary key auto_increment,
    flight_id int,
    seat_number varchar(10) unique,
    is_booked boolean default false,
    class enum('economy', 'business'),
    foreign key (flight_id) references flights(flight_id)
);

--  bookings table
create table bookings (
    booking_id int primary key auto_increment,
    user_id int,
    flight_id int,
    total_amount decimal(10, 2),
    status enum('booked', 'cancelled'),
    booking_date datetime default current_timestamp,
    foreign key (user_id) references users(user_id),
    foreign key (flight_id) references flights(flight_id)
);

-- booking_seats table
create table booking_seats (
    id int primary key auto_increment,
    booking_id int,
    seat_id int,
    foreign key (booking_id) references bookings(booking_id),
    foreign key (seat_id) references seats(seat_id)
);

--  payments table
create table payments (
    payment_id int primary key auto_increment,
    booking_id int,
    payment_method enum('upi', 'card', 'netbanking'),
    amount_paid decimal(10, 2),
    payment_status enum('failed', 'paid', 'pending'),
    payment_date datetime default current_timestamp,
    foreign key (booking_id) references bookings(booking_id)
);

-- . booking_history table
create table booking_history (
    history_id int primary key auto_increment,
    booking_id int,
    action  enum('booked', 'cancelled') not null,
    action_date datetime default current_timestamp,
    foreign key (booking_id) references bookings(booking_id)
);

