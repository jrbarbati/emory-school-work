/* THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati */
/* Find snum and sname of suppliers who have at least 3 shipments going to 
projects in every city. */
select distinct spj.snum, supplier.sname
from spj, supplier
where spj.snum in (select S.snum
				   from supplier S, spj, proj J
				   where spj.snum = S.snum
			       and   spj.jnum = J.jnum
			       group by S.snum
			       having count(distinct J.city) = (select count(distinct city)
												    from proj)
   				   )	
and supplier.snum = spj.snum
group by spj.snum, spj.jnum
having count(distinct qty) >= 3
order by spj.snum