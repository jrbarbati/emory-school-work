/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Find snum and sname of suppliers who do not supply any `Nut's. */
select distinct snum, sname
from supplier
where snum in (select snum
			   from supplier)
and snum not in (select supplier.snum
				 from supplier, part, spj
				 where supplier.snum = spj.snum
				 and part.pnum = spj.pnum
				 and part.pname = 'Nut')
order by snum