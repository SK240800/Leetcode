# Write your MySQL query statement below
with d as(
    select e.student_id, s.student_name,
    rank() over (partition by exam_id order by score desc) as r1,
    rank() over (partition by exam_id order by score asc) as r2
from Exam e
left join Student s
on s.student_id=e.student_id
)

select student_id, student_name
from d
group by student_id
having min(r1)!=1 and min(r2)!=1
order by student_id

