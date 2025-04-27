# Write your MySQL query statement below
select m.customer_id,m.product_id,p.product_name
from(select customer_id,product_id,dense_rank()over(partition by customer_id order by count(product_id) desc) as dr
from Orders
group by customer_id,product_id) m
left join Products p
on p.product_id=m.product_id
where m.dr=1