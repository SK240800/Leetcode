select person_name
from(
    select person_name,sum(weight) over (order by turn rows between unbounded preceding
    and current row) as cs
from Queue) as r
where cs<=1000
order by cs desc
limit 1
