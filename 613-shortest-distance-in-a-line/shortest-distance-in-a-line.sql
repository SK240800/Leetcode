# Write your MySQL query statement below
select min(abs(p2.x-p1.x)) as shortest
from Point p1 
left join Point p2
on p1.x!=p2.x




