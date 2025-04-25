with a as (select sale_date,fruit,sold_num
from Sales
where fruit ='apples'),
o as (select sale_date,fruit,sold_num
from Sales
where fruit ='oranges')

select a.sale_date,a.sold_num-o.sold_num as diff
from a
join o 
on a.sale_date=o.sale_date

