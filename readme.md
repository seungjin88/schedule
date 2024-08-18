sql
```
create table schedule
(
id       bigint auto_increment
primary key,
task     varchar(255) not null,
name     varchar(255) not null,
password varchar(255) not null,
regDate  datetime(6)  null,
modDate  datetime(6)  null
);
```

API

https://documenter.getpostman.com/view/37607351/2sA3s9CoKq


ERD

![image](https://github.com/user-attachments/assets/578f8831-ce9d-4c05-abb3-cc2ce989b279)
