/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Find jnum and jname of projects that only use parts that are manufactured in
the same city where the project takes place. */
select distinct jnum, jname
from proj A
where not exists (select *
				  from part P
				  where P.pnum in (select part.pnum
						 		   from part, spj, proj
						 		   where spj.pnum = part.pnum
						 		   and   spj.jnum = proj.jnum
						 		   and   P.pnum   = part.pnum
						 		   and   A.jnum   = proj.jnum)
				  and P.pnum not in (select part.pnum
						 		   	 from part, spj, proj
						 		   	 where spj.pnum  = part.pnum
						 		   	 and   spj.jnum  = proj.jnum
						 		   	 and   P.pnum    = part.pnum
						 		   	 and   part.city = proj.city
						 		   	 and   A.jnum    = proj.jnum)
				  )
order by jnum
