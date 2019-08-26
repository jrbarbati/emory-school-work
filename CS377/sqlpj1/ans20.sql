/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Find snum and sname of suppliers who only supply to projects in "Rome". */
select snum, sname
from supplier A
where not exists (select proj.city
				  from proj 
				  where proj.city in (select proj.city 
				  				  	  from supplier, spj, proj
				  				  	  where supplier.snum = spj.snum
				  				  	  and   proj.jnum = spj.jnum
				  				  	  and   supplier.snum = A.snum)
				  and proj.city not in (select proj.city 
				  						from proj
				  						where proj.city = 'Rome')
				  )
order by snum