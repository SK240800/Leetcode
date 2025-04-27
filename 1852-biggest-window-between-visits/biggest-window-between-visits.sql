select user_id, max(w) as biggest_window
from(select user_id,
                datediff(ifnull(lead(visit_date,1)over(partition by user_id order by visit_date ),'2021-1-1'),visit_date) as w
from UserVisits) m
group by user_id
