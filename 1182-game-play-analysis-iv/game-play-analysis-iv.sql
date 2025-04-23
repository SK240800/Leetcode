with cte as(
    select min(a.event_date) as x ,a.player_id
    from Activity a
    group by player_id
)
select round(sum(case when datediff(a.event_date,c.x)=1 then 1 else 0 end)/count(distinct a.player_id ),2) as fraction
from Activity a
join cte c
on a.player_id=c.player_id
