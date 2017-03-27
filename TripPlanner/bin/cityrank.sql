delete from cityrank;

insert into cityrank (cityid, categoryid, rank, coveragemindays, coveragemaxdays) Select cityid, categoryid,SMALLINT ( RAND () *10 + 1 ), SMALLINT ( RAND () *2 + 1 ), SMALLINT ( RAND () *5 + 1 )  from CITY, category;

update cityrank set coveragemindays=1 where coveragemindays > coveragemaxdays;


delete from cityrank where categoryid in (10,20,9, 15, 19)

select SMALLINT ( RAND () *10 + 1 ) from sysibm.sysdummy1


update cityrank set rank=(select SMALLINT ( RAND () *10 + 1 ) from sysibm.sysdummy1)

update city set rank= SMALLINT ( RAND () *10 + 1 ) 