# Write your MySQL query statement below

select r.Employee as Employee, r.Department as Department, r.Salary as Salary
from(
    select e.name as Employee,d.name as Department,e.salary as Salary,dense_rank() over
    (partition by e.departmentId order by e.salary desc ) as d
    from Employee e
    join Department d
    on d.id=e.departmentId) as r
where r.d<=3


