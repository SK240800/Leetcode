# Write your MySQL query statement below
select c.name as customer_name ,m.customer_id,m.order_id,m.order_date
from(select *,
dense_rank() over (partition by customer_id order by order_date desc ) as dr
from Orders) m
join Customers c using(customer_id)
where dr<=3
order by c.name,m.customer_id,order_date desc