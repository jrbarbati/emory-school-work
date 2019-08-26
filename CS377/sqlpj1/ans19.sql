/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Find snum and sname of suppliers who supply all (every single) "Bolt" parts. */
select distinct snum, sname
from supplier S
where not exists (select *
				  from part P
				  where P.pnum     in (select pnum
				  					   from part 
				  					   where pname = 'Bolt')
				  and   P.pnum not in (select part.pnum
				  					   from part, spj, supplier
				  					   where spj.pnum = part.pnum
				  					   and   spj.snum = supplier.snum
				  					   and   S.snum   = supplier.snum
				  					   and   P.pnum   = part.pnum)
				 )
order by snum