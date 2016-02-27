insert into albums (id,name,created_date) values (albums_seq.nextval,'Vacation 2016',null);

insert into photos (id,name,created_date,album_id) values (photos_seq.nextval,'At the beach',null,albums_seq.currval);
insert into photos (id,name,created_date,album_id) values (photos_seq.nextval,'At the park',null,albums_seq.currval);
insert into photos (id,name,created_date,album_id) values (photos_seq.nextval,'On the road',null,albums_seq.currval);

insert into albums (id,name,created_date) values (albums_seq.nextval,'Selfies',null);

insert into photos (id,name,created_date,album_id) values (photos_seq.nextval,'In class',null,albums_seq.currval);
insert into photos (id,name,created_date,album_id) values (photos_seq.nextval,'At home',null,albums_seq.currval);
insert into photos (id,name,created_date,album_id) values (photos_seq.nextval,'At concert',null,albums_seq.currval);
