/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/ 
/* Get project numbers of projects that are supplied by some supplier in the
same city as the project with a part manufactured in the same city as the project */
select distinct jnum
from spj
where spj.jnum in (select proj.jnum
				   from supplier, proj, spj, part
				   where proj.city = supplier.city
				   and part.city = proj.city
				   and spj.snum = supplier.snum
				   and spj.jnum = proj.jnum
				   and spj.pnum = part.pnum)
order by jnum