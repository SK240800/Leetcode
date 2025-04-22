# Write your MySQL query statement below
select 
    id,
    movie,
    description,
    rating
from Cinema
WHERE MOD(id, 2) = 1 and description !='boring'
order by rating DESC
