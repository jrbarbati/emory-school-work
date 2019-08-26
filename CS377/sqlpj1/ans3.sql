/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Get part numbers for parts supplied to some project in Paris. */
select distinct spj.pnum
from spj
where spj.jnum in (select jnum
				   from proj
				   where city = 'Paris')
order by spj.pnum