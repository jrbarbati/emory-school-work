/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati */
/* Find snum and snames of suppliers that can supply every part (pnum) that are 
used by projects in "Atlanta". */
/* pnum supplied by supplier contains part used in projects in ATL */
select distinct S.snum, S.sname
from supplier S
where not exists (select *
				  from part
				  where pnum     in (select spj.pnum
				  					 from spj, part, proj
				  					 where spj.pnum  = part.pnum
				  					 and   spj.jnum  = proj.jnum
				  					 and   proj.city = 'Atlanta')
				  and   pnum not in (select spj.pnum
				  					 from spj, part, supplier
				  					 where spj.snum = supplier.snum
				  					 and   spj.pnum = part.pnum
				  					 and   spj.snum = S.snum)
				 )
order by S.snum