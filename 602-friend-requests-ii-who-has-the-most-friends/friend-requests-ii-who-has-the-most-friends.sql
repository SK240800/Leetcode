select id, sum(num) as num
from
((select accepter_id as id , count(requester_id) as num
from RequestAccepted
group by accepter_id)

union all

(select requester_id as id , count(accepter_id) as num
from RequestAccepted
group by requester_id)) as m
group by id
order by num desc
limit 1

