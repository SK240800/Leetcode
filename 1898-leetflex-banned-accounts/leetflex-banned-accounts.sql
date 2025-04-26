# Write your MySQL query statement below
select l1.account_id
from LogInfo l1
left join LogInfo l2 
on l1.account_id=l2.account_id
where l1.ip_address!=l2.ip_address and  l1.login <= l2.logout AND l2.login <= l1.logout
group by l1.account_id