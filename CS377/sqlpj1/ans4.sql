/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Get part numbers for parts that are not supplied to any project in Paris. */
select distinct pnum
from spj
where spj.pnum in (select pnum
				   from part)
and spj.pnum not in (select pnum
					 from spj, part, proj
					 where spj.pnum = spj.pnum
					 and spj.jnum = proj.jnum
					 and proj.city = 'Paris')
order by pnum