/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
WRITTEN BY OTHER STUDENTS - Joseph Barbati */
/* Find snum and sname of suppliers who have 3 or more shipments to all 
projects in the city they live in. */
select distinct S.snum, S.sname
from supplier S, spj, proj J
where spj.snum = S.snum
and   spj.jnum = J.jnum
and   S.city   = J.city
group by S.snum
having count(qty) > 3
order by S.snum