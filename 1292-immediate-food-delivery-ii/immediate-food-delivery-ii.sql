with cte as(
    select customer_id,delivery_id,case when min(order_date)-min(customer_pref_delivery_date)=0 then 1 else 0 end as x
    from Delivery
    group by customer_id
 
)
select round(sum(x)*100/count(x),2) as immediate_percentage
from cte
