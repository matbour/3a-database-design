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

### Glassfish 5.0
- JDBC Connection Pool name: `postgresql_pool`
- JDBC Resource name : `postgresql_resource`
