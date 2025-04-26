# Write your MySQL query statement below
select p.product_name,m.product_id,m.order_id,m.order_date
from(select product_id,order_id,order_date,
dense_rank() over (partition by product_id order by order_date desc) as dr
from Orders) m
left join Products p
on p.product_id =m.product_id
where dr =1
order by product_name,order_id