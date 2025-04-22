select name
from Employee
where Id in (
    select managerId
    from Employee
    group by managerId
    having count(managerId)>=5
)





