# Write your MySQL query statement below
with cte as (select team_id,count(employee_id) as size
from Employee
group by team_id)

select e.employee_id,c.size as team_size
from Employee e
left join cte c
using(team_id)