# Write your MySQL query statement below
select distinct title
from Content
join TVProgram using(content_id)
where Kids_content='Y' and month(program_date)=6 and year(program_date)=2020 and content_type='Movies'