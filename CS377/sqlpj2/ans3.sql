/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
WRITTEN BY OTHER STUDENTS - Joseph Barbati */
/* Find snum and sname of suppliers who supply the same project with > 3 
different parts. */
select distinct supplier.snum, sname 
from supplier, spj, proj, part
where spj.snum = supplier.snum
and   spj.pnum = part.pnum
and   spj.jnum = proj.jnum
group by proj.jnum, supplier.snum
having count(distinct part.pnum) > 3
order by supplier.snum