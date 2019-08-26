/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Find jnum of projects that do not use any locally made parts (i.e., if the 
project takes place in city x, then it does not use any part made in city x).*/
select distinct spj.jnum
from spj
where spj.jnum not in (select spj.jnum
					   from part, spj, proj
					   where part.pnum = spj.pnum
					   and   proj.jnum = spj.jnum
					   and   part.city = proj.city)
order by spj.jnum