(select employee_id
from Salaries
where employee_id not in (
    select employee_id
    from Employees
)
union

select employee_id
from Employees
where employee_id not in (
    select employee_id
    from Salaries))
order by employee_id