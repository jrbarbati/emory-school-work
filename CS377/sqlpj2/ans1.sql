/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE
WRITTEN BY OTHER STUDENTS - Joseph Barbati */
/* Get snum and sname for suppliers that supply to > 2 distinct projects in 
"Rome" and to < 4 distinct projects in "Paris".  */
select distinct snum, sname
from supplier
where snum in (select supplier.snum 
			   from supplier, spj, proj
			   where spj.jnum  = proj.jnum
			   and   spj.snum  = supplier.snum
			   and   proj.city = 'Rome'
			   group by supplier.snum
			   having count(distinct proj.jnum) > 2)
and   snum in (select snum 
			   from supplier
			   where snum in (select supplier.snum /* Gets all suppliers that supply to 1 <= n < 4 projects in Paris (missing n == 0) */
			   				  from supplier, spj, proj
			   				  where spj.jnum  = proj.jnum
			   				  and   spj.snum  = supplier.snum
			   				  and   proj.city = 'Paris'
			   				  group by supplier.snum
			   				  having count(distinct proj.jnum) < 4)
			   or    snum in (select supplier.snum /* Gets all suppliers that supply to 0 projects in Paris */
			   				  from supplier, spj, proj
			   				  where spj.jnum  = proj.jnum
			   				  and   spj.snum  = supplier.snum
			   				  and   proj.city != 'Paris')
			  )
order by snum