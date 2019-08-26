/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Get project numbers for projects that use at least one part that is 
available from supplier s4. 
Note: get the availability information from the spj relation. 
Note: the project need not be supplied by 's4' as long as it uses some part 
that `s4' supplies. */
select distinct spj.jnum
from spj
where spj.pnum in (select spj.pnum 
				   from supplier, part, spj
				   where supplier.snum = 's4'
				   and part.pnum = spj.pnum
				   and spj.snum = 's4')
order by spj.jnum