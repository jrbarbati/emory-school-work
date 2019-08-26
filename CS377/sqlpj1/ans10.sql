/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Find jnum and jname of projects that do not use any red parts. */
select distinct proj.jnum, jname
from proj
where proj.jnum not in (select spj.jnum
						from   spj, part, proj
						where  spj.jnum = proj.jnum
						and    spj.pnum = part.pnum
						and    part.color = 'Red')
order by proj.jnum