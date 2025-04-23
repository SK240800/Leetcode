with cte as(
    select count(*) as n
    from Product
)
select customer_id
from Customer
group by customer_id
having count(distinct product_key)=( 
    select n
    from cte
)