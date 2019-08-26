/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati */
/* For each project, list the jnum, jname and the total weight of parts from 
"Smith" being shipped to the project. */
select J.jnum, J.jname, sum(P.weight * spj.qty)
from spj, proj J, part P, supplier S
where spj.jnum  = J.jnum
and   spj.pnum  = P.pnum
and   spj.snum  = S.snum
and   S.sname   = 'Smith'
group by J.jnum