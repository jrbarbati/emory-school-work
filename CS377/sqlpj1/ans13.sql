/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Get snum and sname for suppliers that do not supply to all (every single) 
projects in "Rome". */
select snum, sname
from supplier A
where exists (select *
				  from proj B
				  where B.jnum in   (select proj.jnum
				  					 from proj
				  					 where proj.city = 'Rome')
				  and B.jnum not in (select proj.jnum
				  					 from proj, supplier, spj
				  					 where proj.jnum = spj.jnum
				  					 and supplier.snum = spj.snum
				  					 and A.snum = supplier.snum)
				 )
order by snum