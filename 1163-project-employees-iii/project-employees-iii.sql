select project_id,employee_id
from(select *,dense_rank() over(partition by project_id order by experience_years desc ) as dr
from Project
join Employee
using(employee_id)) m
where dr = 1
