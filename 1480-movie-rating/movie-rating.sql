(select u.name as results
from MovieRating m
join Users u
on u.user_id = m.user_id
group by m.user_id
order by count(m.rating) desc, u.name
limit 1)

union all

(select m.title as results
from MovieRating mr
join Movies m
on m.movie_id=mr.movie_id
where mr.created_at >= '2020-02-01' AND mr.created_at < '2020-03-01'
group by mr.movie_id
order by avg(mr.rating) desc, m.title
limit 1)



