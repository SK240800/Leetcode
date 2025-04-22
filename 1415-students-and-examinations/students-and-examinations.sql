with crs as(
    select s.student_id, s.student_name, sub.subject_name
    from Students s
    cross join Subjects sub
)
select c.student_id,c.student_name,c.subject_name,IFNULL(grouped.attended_exams, 0) AS attended_exams
from crs c
left join (
    select student_id,subject_name, COUNT(*) as attended_exams
    from Examinations
    group by student_id, subject_name
) grouped
on c.student_id = grouped.student_id AND c.subject_name = grouped.subject_name
ORDER BY c.student_id, c.subject_name;
