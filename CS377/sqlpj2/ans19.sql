/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati */
/* Find jnum and jnames of all projects that uses all parts that are heavier 
than 15. */
/* pnum of projects contains pnums of parts > 15 */
select distinct J.jnum, J.jname
from proj J
where not exists (select *
				  from part 
				  where pnum in (select pnum
				  				 from part
				  				 where weight > 15)
				  and   pnum not in (select part.pnum
				  					 from part, spj, proj
				  					 where spj.pnum = part.pnum
				  					 and   spj.jnum = proj.jnum
				  					 and   spj.jnum = J.jnum)
				 )
order by J.jnum