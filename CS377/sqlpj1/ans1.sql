/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Get part numbers of parts supplied by a supplier in London to a project in London. */
select distinct pnum
from spj
where spj.jnum in (select proj.jnum
				   from proj 
				   where proj.city = 'London')
and   spj.snum in (select supplier.snum
				   from supplier
				   where supplier.city = 'London')
order by pnum