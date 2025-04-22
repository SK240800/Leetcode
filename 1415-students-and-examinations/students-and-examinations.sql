select s.student_id,s.student_name,sb.subject_name,coalesce(gp.attended_exams,0)as attended_exams
from Students s
cross join Subjects sb
left join(
    select student_id,subject_name,count(*) as attended_exams
    from Examinations
    group by student_id,subject_name
) gp
on s.student_id=gp.student_id and sb.subject_name=gp.subject_name
ORDER by s.student_id,sb.subject_name