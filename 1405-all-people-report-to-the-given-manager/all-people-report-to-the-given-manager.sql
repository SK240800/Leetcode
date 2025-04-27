-- # Write your MySQL query statement below
-- select employee_id
-- from Employees
-- where manager_id=1 and employee_id!=1
-- union
-- select employee_id
-- from Employees
-- where manager_id in(select employee_id
-- from Employees where manager_id=1) and manager_id!=1
-- union
-- select employee_id
-- from Employees
-- where manager_id in (select employee_id
-- from Employees
-- where manager_id in(select employee_id
-- from Employees where manager_id=1) and manager_id!=1)

-- select e3.employee_id 
-- from Employees e1
-- join Employees e2
-- on e2.manager_id=e1.employee_id
-- join Employees e3
-- on e3.manager_id=e2.employee_id
-- where e1.manager_id=1 and e3.employee_id!=1

with recursive cte as (

    select employee_id,manager_id
    from Employees
    where employee_id!=1 and manager_id = 1 

    union all

    select e.employee_id,e.manager_id
    from Employees e
    inner join cte c
    on e.manager_id=c.employee_id
)
select employee_id 
from cte


