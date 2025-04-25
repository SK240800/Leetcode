# Write your MySQL query statement below
with cte as (select product_id, (p.Width*p.Length*p.Height) as volume
from Products p)

select w.name as warehouse_name  , sum(w.units*volume) as volume
from Warehouse w
join cte c
on c.product_id= w.product_id
group by w.name