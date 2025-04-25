# Write your MySQL query statement below
-- select user_id, time_stamp as last_stamp from(
--     select user_id ,time_stamp,dense_rank() over (partition by user_id order by time_stamp desc) as r
--     from Logins
--     having year(time_stamp)=2020) as r
-- where r=1
-- order by user_id

select distinct user_id,first_value(time_stamp)over(partition by user_id order by time_stamp desc) as last_stamp
from Logins
where year(time_stamp)=2020

