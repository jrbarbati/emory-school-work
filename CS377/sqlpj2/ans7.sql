/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
WRITTEN BY OTHER STUDENTS - Joseph Barbati */
/* For each supplier, find snum, sname, and the pnum and pname of parts that 
the supplier supplies, but only for parts that the supplier supplies to > 3 
projects. */
select distinct S.snum, sname, P.pnum, pname
from spj, supplier S, part P
where spj.snum = S.snum
and   spj.pnum = P.pnum
group by spj.snum, spj.pnum
having count(spj.jnum) > 3
order by S.snum