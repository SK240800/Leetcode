# Write your MySQL query statement below
select transaction_id 
from(select *, rank() over (partition by day(day) order by amount desc ) as dr from Transactions) m
where dr=1
order by transaction_id