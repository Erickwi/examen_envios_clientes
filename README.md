Previamente se debe crear el usuario

```bash
CREATE USER 'root123'@'localhost' IDENTIFIED BY 'abcd';
GRANT ALL PRIVILEGES ON *.* TO 'root123'@'localhost';
FLUSH PRIVILEGES;
SELECT User, Host FROM mysql.user;
```

Y también la base de datos

```bash
create database sisdb_examen
```

