# Write your MySQL query statement below
select distinct player_id, first_value(event_date) over (partition by player_id order by event_date asc) as first_login
from Activity
