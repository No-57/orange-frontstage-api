FROM postgres:16.0

# copy local DB_SCHEMA.sql to /docker-entrypoint-initdb.d
# /docker-entrypoint-initdb.d will init schema
COPY DB_SCHEMA.sql /docker-entrypoint-initdb.d/

# set user and password
ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=password

# expose port
EXPOSE 5432
