# database-design-java
Database design wonderfully powered by JAVA, ORACLE and all that stuff

# Contributors

[Mathieu Bour](https://github.com/mathieu-bour) and
[Dimitri Bret](https://github.com/dimitri-bret)

## Configuration

### PostgreSQL
PostresSQL server 9.4 running on Docker with the image `postgres:9.4-alpine` with the following environment variables:

| Key               | Value    |
|-------------------|----------|
| POSTGRES_PASSWORD | postgres |
| POSTGRES_USER	    | postgres |
| POSTGRES_DB       | postgres |

Use of the default `postgres/public` database.

### Glassfish 5.0
- JDBC Connection Pool name: `postgresql_pool`
- JDBC Resource name : `postgresql_resource`
- JDBC Postgresql Driver: `postgresql-9.4.1212.jre6.jar`, placed in `glassfish5/glassfish/domains/domain1/lib` 

### Initial SQL

```postgresql
create table livre
(
    isbn  char(4)            not null primary key,
    titre char(20),
    dispo smallint default 1 not null,
    check (dispo in (0, 1))
);

create table emprunteur
(
    numemp      int not null primary key,
    nom         char(20),
    nblivresemp int default 0
);
create table livre_emp
(
    isbn        char(4) not null primary key,
    titre       char(20),
    empruntepar int default 0 references emprunteur (numemp),
    check (empruntepar >= 0)
);


insert into livre
values ('111', 'Le petit prince', 1),
       ('222', 'Le rouge et le noir', 1),
       ('333', 'Germinal', 1),
       ('444', 'Le pere Goriot', 1),
       ('555', 'Le tour du monde', 1),
       ('666', 'Vendredi', 1);
insert into emprunteur
values (1, 'Jean', 0),
       (2, 'Jacques', 0),
       (3, 'Paul', 0),
       (0, 'Bidon', 0);
```