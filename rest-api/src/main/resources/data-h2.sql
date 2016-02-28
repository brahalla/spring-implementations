insert into albums (id,name,created_date) values (albums_seq.nextval,'Vacation 2016',parsedatetime('17-JUL-15 12:30:00','dd-MMM-yy HH:mm:ss'));

insert into photos (id,name,created_date,album_id) values (photos_seq.nextval,'At the beach',parsedatetime('17-JUL-15 12:31:00','dd-MMM-yy HH:mm:ss'),albums_seq.currval);
insert into photos (id,name,created_date,album_id) values (photos_seq.nextval,'At the park',parsedatetime('17-JUL-15 12:31:30','dd-MMM-yy HH:mm:ss'),albums_seq.currval);
insert into photos (id,name,created_date,album_id) values (photos_seq.nextval,'On the road',parsedatetime('18-JUL-15 07:15:00','dd-MMM-yy HH:mm:ss'),albums_seq.currval);

insert into albums (id,name,created_date) values (albums_seq.nextval,'Selfies',parsedatetime('09-OCT-15 14:42:00','dd-MMM-yy HH:mm:ss'));

insert into photos (id,name,created_date,album_id) values (photos_seq.nextval,'In class',parsedatetime('09-OCT-15 14:43:15','dd-MMM-yy HH:mm:ss'),albums_seq.currval);
insert into photos (id,name,created_date,album_id) values (photos_seq.nextval,'At home',parsedatetime('12-OCT-15 11:18:00','dd-MMM-yy HH:mm:ss'),albums_seq.currval);
insert into photos (id,name,created_date,album_id) values (photos_seq.nextval,'At concert',parsedatetime('13-DEC-15 20:16:00','dd-MMM-yy HH:mm:ss'),albums_seq.currval);
