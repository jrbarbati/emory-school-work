/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Find jnum and jname of projects that use all (every single) parts that are 
used in project 'j3'. */
select distinct jnum, jname
from proj A
where not exists (select *
				  from part B
				  where B.pnum in   (select part.pnum
				  					 from proj C, spj, part
				  					 where C.jnum = 'j3'
				  					 and   spj.pnum = part.pnum
				  					 and   B.pnum = part.pnum
				  					 and   C.jnum = spj.jnum)
				  and B.pnum not in (select part.pnum
				  					 from proj D, supplier, spj, part
				  					 where D.jnum = spj.jnum
				  					 and supplier.snum = spj.snum
				  					 and A.jnum = D.jnum
				  					 and   spj.pnum = part.pnum
				  					 and   B.pnum = part.pnum)
				 )
order by jnum