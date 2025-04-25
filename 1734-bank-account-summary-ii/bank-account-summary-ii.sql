# Write your MySQL query statement below
with cte as (select account,sum(amount) as Balance
from Transactions
group by account
having balance>10000)

select name,c.Balance
from Users u
join cte c
on u.account=c.account
