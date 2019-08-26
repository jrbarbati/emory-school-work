/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Get snum and sname for suppliers that supply to all (every single) projects 
in "Rome". */
select distinct snum
from supplier S
where not exists (select *
				  from proj B
				  where B.jnum in   (select proj.jnum
				  					 from proj
				  					 where proj.city = 'Rome')
				  and B.jnum not in (select proj.jnum
				  					 from proj, supplier, spj
				  					 where proj.jnum = spj.jnum
				  					 and supplier.snum = spj.snum
				  					 and S.snum = supplier.snum)
				 )
order by snum