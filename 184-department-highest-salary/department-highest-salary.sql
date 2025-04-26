# Write your MySQL query statement below
select Department,Employee,Salary
from (select d.name as Department,e.name as Employee, e.salary as Salary
,dense_rank()over(partition by e.departmentId order by salary desc) as dr
from Employee e
join Department d
on e.departmentId=d.id) m
where dr=1