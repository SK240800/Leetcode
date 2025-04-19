# Write your MySQL query statement below
SELECT emp.unique_id, e.name
FROM Employees e
LEFT JOIN EmployeeUNI emp
ON emp.id = e.id