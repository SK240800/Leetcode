select player_id,device_id
from (select player_id,device_id,
dense_rank() over (partition by player_id order by event_date ) as dr
from Activity) as m
where dr=1



