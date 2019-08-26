/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Find jnum and jname of projects that only uses red parts. */
/* Every proj's part should be a subset of all the parts that are red. */
select jnum, jname
from proj A
where not exists (select color
				  from part 
				  where color in (select color 
				  				  from part, spj, proj
				  				  where part.pnum = spj.pnum
				  				  and   proj.jnum = spj.jnum
				  				  and   proj.jnum = A.jnum)
				  and color not in (select color 
				  					from part
				  					where color = 'Red')
				  )
order by jnum