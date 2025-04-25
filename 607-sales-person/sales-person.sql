select j as name from(select s.name as j,r.name
from SalesPerson s
left join (
    select o.sales_id,name
    from Orders o
    left join Company c
    on o.com_id=c.com_id
    ) as r
on s.sales_id=r.sales_id
group by s.name
having r.name!='RED' or r.name is null) as e

