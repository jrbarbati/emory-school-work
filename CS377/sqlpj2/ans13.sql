/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati */
/* Find snum and sname of suppliers for which the color of one of the lightest 
(i.e., minimum weight) part they supply is "Blue". */ 
select A.snum, A.sname
from (select S.snum, S.sname, P.pnum, min(weight)
	  from supplier S, part P, spj
	  where spj.snum = S.snum
	  and   spj.pnum = P.pnum
	  group by S.snum, P.pnum) A, part P
where A.pnum = P.pnum
group by A.snum
having min(weight) in (select weight
					   from part
					   where color = 'Blue')