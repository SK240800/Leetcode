# Write your MySQL query statement below
with pqp as(select query_name, count(rating)as poor_query_percentage
from Queries 
where rating < 3
group by query_name)

select q.query_name, round(sum((q.rating/q.position))/count(q.rating),2) as quality,
coalesce(round(p.poor_query_percentage*100/count(q.rating),2),0) as poor_query_percentage
from Queries q
left join pqp p
on q.query_name = p.query_name
group by query_name