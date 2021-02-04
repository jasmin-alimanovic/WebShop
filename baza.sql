drop database dbproizvodi_35;
create database dbproizvodi_35;

use dbproizvodi_35;

create table role
(
	id int not null primary key auto_increment,
    name nvarchar(20)
    
);

insert into role(name) values ("user"), ("admin");

create table korisnik
(
	id int not null primary key auto_increment,
    ime nvarchar(20),
    prezime nvarchar(20),
    email nvarchar(100) not null unique,
    username nvarchar(50) unique,
    password nvarchar(50) not null,
    adresa nvarchar(100),
    telefon nvarchar(20),
    role_id int not null default 1,
    constraint FK_korisnik_role foreign key(role_id) references role(id)
);

create table status
(
	id int not null primary key auto_increment,
    name nvarchar(30)
);

insert into status(name) values ("Nezavrsena"), ("Zavrsena");

create table kategorija 
(
	id int not null primary key auto_increment,
    name nvarchar(30)
);

insert into kategorija (name) values ("Avantura"), ("Detektivska"), ("Kriminalisticka"), ("Drama"), ("Tragedija"), ("Komedija"), ("Tragikomedija"), ("Trivijalna"), ("Historijska"), ("Roman"), ("Djecija");

select * from kategorija;
create table narudzba
(
	id int not null primary key auto_increment,
    dtm_narudzbe datetime default now(),
    status_id int  not null,
    korisnik_id int not null,
    constraint FK_narudzba__status foreign key(status_id) references status(id),
    constraint FK_narudzba__korisnik foreign key(korisnik_id) references korisnik(id)
);

create table korpa
(
	id int not null primary key auto_increment,
    korisnik_id int not null,
    proizvod_id int not null,
    constraint FK_korpa__korisnik foreign key(korisnik_id) references korisnik(id)
    
);


create table proizvod
(
	id int not null primary key auto_increment,
    name nvarchar(40) not null,
    opis text,
    cijena double,
    kolicina int,
    ime_autora text,
    prezime_autora text,
    korisnik_id int,
    kategorija_id int,
    korpa_id int null,
    constraint FK_proizvod__korisnik foreign key(korisnik_id) references korisnik(id),
    constraint FK_proizvod__kategorija foreign key(kategorija_id) references kategorija(id)
);

create table narudzba_stavke
(
	id int not null primary key,
    kolicina int,
    narudzba_id int not null,
    proizvod_id int not null,
    constraint FK__narudzba_stavke__narudzba foreign key(narudzba_id) references narudzba(id),
    constraint FK__narudzba_stavke__proizvoda foreign key(proizvod_id) references proizvod(id)
);



















