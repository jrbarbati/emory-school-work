/*THIS CODE IS MY OWN WORK, IT WAS WRITTEN WITHOUT CONSULTING A TUTOR OR CODE 
WRITTEN BY OTHER STUDENTS - Joseph Barbati*/
/* Find sname of suppliers who do not supply any part heavier than 18 (to any 
project). */
select sname 
from supplier A
where  not exists
           (select *
            from   part
            where  weight in (select weight
                              from   part 
                              where  weight > 18)
            and    weight in (select weight 
            				  from   part, supplier, spj
            				  where  part.pnum     = spj.pnum
            				  and    supplier.snum = spj.snum
            				  and    supplier.snum = A.snum)
            )
order by sname