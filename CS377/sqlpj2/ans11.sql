/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati */
/* Find jnum and jname of projects that use any one of the second heaviest 
part(s). */
select distinct P.jnum, P.jname
from proj P
where P.jnum in (select proj.jnum
			     from spj, proj, part
			     where spj.jnum = proj.jnum
			     and   spj.pnum = part.pnum
			     and   part.weight = (select max(weight)
							          from part
							          where weight != (select max(weight)
											           from part)
							         )
			    )  
order by P.jnum