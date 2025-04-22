select
    s.user_id,
    round(avg(case when c.action='confirmed' then 1.00 else 0 end),2) as confirmation_rate
from Signups s
left join 
    Confirmations c
    ON
    s.user_id = c.user_id
GROUP BY
    s.user_id
order by confirmation_rate