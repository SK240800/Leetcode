with cte as (select count(delivery_id) as imd
from Delivery
where order_date = customer_pref_delivery_date)

select round(imd*100/count(delivery_id),2) as immediate_percentage
from cte,Delivery