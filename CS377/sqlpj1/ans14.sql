/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Get snum and sname for suppliers that supply to some projects in "Rome" but
not to all (every single) projects in "Rome". */
select distinct snum, sname
from supplier S
where exists (select *
			  from supplier P
			  where P.snum not in  (select snum
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
								   )
			  and   P.snum     in (select supplier.snum
							  	   from proj, spj, supplier
							  	   where proj.city = 'Rome'
							  	   and   spj.jnum = proj.jnum
							  	   and   spj.snum = supplier.snum
							  	   and   S.snum   = supplier.snum)
			 )
order by snum