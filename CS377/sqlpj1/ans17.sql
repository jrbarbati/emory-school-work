/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Find snum and sname of suppliers who supply all (every single) blue parts 
but do not supply any green part. */
/* {parts supplied by supplier} should contain {all blue parts} */
/* {all blue parts} - {parts supplied by supplier} should be {} */
/* not exists something in {all blue parts} and not in {parts supplied by supplier} */
select distinct snum, sname
from supplier S
where not exists (select *
				  from part
				  where pnum     in (select pnum
				  					 from part
				  					 where part.color = 'Blue')
				  and   pnum not in (select part.pnum
				  					 from supplier, part, spj
				  					 where spj.snum = supplier.snum
				  					 and   spj.pnum = part.pnum
				  					 and   S.snum   = supplier.snum)
				 )
and       exists (select *
				  from part
				  where pnum     in (select pnum
				  					 from part
				  					 where part.color = 'Green')
				  and   pnum not in (select part.pnum
				  					 from supplier, part, spj
				  					 where spj.snum = supplier.snum
				  					 and   spj.pnum = part.pnum
				  					 and   S.snum   = supplier.snum)
				 )
order by snum