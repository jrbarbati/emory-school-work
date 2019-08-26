/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Find snum and sname of suppliers who supply at least one part of every 
possible color. */
select distinct snum, sname 
from spj, supplier, part
where spj.pnum = part.pnum
and spj.snum = supplier.snum
group by supplier.snum
having count(distinct part.color) = 4
