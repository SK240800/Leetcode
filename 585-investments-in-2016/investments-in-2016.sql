# Write your MySQL query statement below
select round(sum(i.tiv_2016),2) as tiv_2016
from Insurance i
join (
    select tiv_2015
    from Insurance
    group by tiv_2015
    having count(tiv_2015)>1) as t1
on i.tiv_2015=t1.tiv_2015
join(
    select pid, concat(lat,lon) as l
    from Insurance
    group by l
    having count(l)=1) as t2
on i.pid=t2.pid

