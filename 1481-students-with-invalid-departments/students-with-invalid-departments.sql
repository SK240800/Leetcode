# Write your MySQL query statement below
-- select s.id, s.name
-- from Students s
-- left join Departments d
-- on d.id=s.department_id
-- where d.name is null

select id , name
from Students
where department_id not in (select id from Departments)