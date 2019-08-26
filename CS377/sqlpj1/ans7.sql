/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Find snum and sname of suppliers that supplies a `Nut'. */
select distinct supplier.snum, sname
from supplier, part, spj
where supplier.snum = spj.snum
and part.pnum = spj.pnum
and part.pname = 'Nut'
order by supplier.snum