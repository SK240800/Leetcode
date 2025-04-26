# Write your MySQL query statement below
select c.name as country
from Country c
join Person p
on SUBSTRING(phone_number,1,3) = country_code
join Calls cl
on p.id IN (cl.caller_id, cl.callee_id)
group by c.name
having  AVG(duration) > (SELECT AVG(duration) FROM calls)
