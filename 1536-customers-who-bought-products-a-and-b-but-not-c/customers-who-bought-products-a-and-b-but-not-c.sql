# Write your MySQL query statement below
-- select distinct f.customer_id,f.customer_name
-- from (
-- select o.customer_id,c.customer_name
-- from Orders o
-- join Customers c
-- on o.customer_id=c.customer_id
-- order by customer_name) as f
-- where (f.customer_id, 'A') in (
--     select customer_id,product_name
--     from Orders) and (f.customer_id, 'B') in (
--     select customer_id,product_name
--     from Orders) and (f.customer_id, 'C')  not in (
--     select customer_id,product_name
--     from Orders)

select c.customer_id, customer_name
from customers c
left join orders o on c.customer_id = o.customer_id
group by c.customer_id
having SUM(product_name='A') > 0
    AND SUM(product_name='B') > 0
    AND SUM(product_name='C') = 0
order by customer_id;
