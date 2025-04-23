select person_name
from(select person_name,sum(weight) over(order by turn) as cs
from Queue
order by turn) as r
where cs<=1000
order by cs desc
limit 1


