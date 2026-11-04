USE University;

-- 1. Display all students
SELECT * FROM student;

-- 2. Students from Ghaziabad
SELECT name, city
FROM student
WHERE city = 'Ghaziabad';

-- 3. Teachers with more than 8 years of experience
SELECT name, designation, experience
FROM teacher
WHERE experience > 8;

-- 4. Students with CGPA between 7.5 and 9.0
SELECT name, cgpa
FROM student
WHERE cgpa BETWEEN 7.5 AND 9.0;

-- 5. Students from Delhi or Noida with CGPA above 8
SELECT name, city, cgpa
FROM student
WHERE city IN ('Delhi', 'Noida')
AND cgpa > 8;

-- 6. Doctors ordered by salary, highest first
SELECT name, salary
FROM teacher
WHERE name LIKE 'Dr.%'
ORDER BY salary DESC;

-- 7. Student count and CGPA statistics
SELECT COUNT(*) AS total_students,
       MAX(cgpa) AS highest_cgpa,
       MIN(cgpa) AS lowest_cgpa,
       ROUND(AVG(cgpa), 2) AS average_cgpa
FROM student;

-- 8. Number of students in each city
SELECT city, COUNT(*) AS student_count
FROM student
GROUP BY city;

-- 9. Average CGPA by admission year
SELECT admission_year,
       ROUND(AVG(cgpa), 2) AS average_cgpa
FROM student
GROUP BY admission_year;

-- 10. Teacher salary statistics by department
SELECT dept_id,
       COUNT(*) AS total_teachers,
       MAX(salary) AS highest_salary,
       MIN(salary) AS lowest_salary,
       ROUND(AVG(salary), 2) AS average_salary
FROM teacher
GROUP BY dept_id;

-- 11. Enrollment count and average marks by course
SELECT course_id,
       COUNT(*) AS enrolled_students,
       ROUND(AVG(marks), 2) AS average_marks
FROM enrollment
GROUP BY course_id;

-- 12. Cities with at least 3 students
SELECT city, COUNT(*) AS student_count
FROM student
GROUP BY city
HAVING COUNT(*) >= 3;

-- 13. Admission years with average CGPA above 8
SELECT admission_year,
       ROUND(AVG(cgpa), 2) AS average_cgpa
FROM student
GROUP BY admission_year
HAVING AVG(cgpa) > 8;

-- 14. Departments with total teacher salary above 150000
SELECT dept_id, SUM(salary) AS total_salary
FROM teacher
GROUP BY dept_id
HAVING SUM(salary) > 150000;

-- 15. Courses with attendance at least 75 and average marks above 75
SELECT course_id,
       COUNT(*) AS student_count,
       ROUND(AVG(marks), 2) AS average_marks
FROM enrollment
WHERE attendance >= 75
GROUP BY course_id
HAVING AVG(marks) > 75;

-- 16. Students and their department names
SELECT s.name AS student_name,
       d.dept_name
FROM student s
INNER JOIN department d
ON s.dept_id = d.dept_id;

-- 17. Teachers and the courses they teach
SELECT t.name AS teacher_name,
       c.course_title
FROM teacher t
INNER JOIN teaches te
ON t.teacher_id = te.teacher_id
INNER JOIN course c
ON te.course_id = c.course_id;

-- 18. Students scoring at least 80 in a course
SELECT s.name AS student_name,
       c.course_title,
       e.marks
FROM student s
INNER JOIN enrollment e
ON s.student_id = e.student_id
INNER JOIN course c
ON e.course_id = c.course_id
WHERE e.marks >= 80;

-- 19. Student count by department (departments with students)
SELECT d.dept_name,
       COUNT(s.student_id) AS student_count
FROM department d
INNER JOIN student s
ON d.dept_id = s.dept_id
GROUP BY d.dept_id, d.dept_name;

-- 20. Teacher count by department, including departments with no teachers
SELECT d.dept_name,
       COUNT(t.teacher_id) AS teacher_count
FROM department d
LEFT JOIN teacher t
ON d.dept_id = t.dept_id
GROUP BY d.dept_id, d.dept_name;

-- 21. Students who are not enrolled in any course
SELECT s.student_id, s.name
FROM student s
LEFT JOIN enrollment e
ON s.student_id = e.student_id
WHERE e.student_id IS NULL;

-- 22. All departments and their students, including departments without students
SELECT d.dept_name,
       s.name AS student_name
FROM student s
RIGHT JOIN department d
ON s.dept_id = d.dept_id
ORDER BY d.dept_id, s.student_id;

-- 23. All courses and their enrollments, including courses without enrollments
SELECT c.course_title,
       e.student_id
FROM enrollment e
RIGHT JOIN course c
ON e.course_id = c.course_id
ORDER BY c.course_id, e.student_id;

-- 24. Teachers and courses in the same department, including unmatched rows
SELECT t.name AS teacher_name,
       c.course_title
FROM teacher t
LEFT JOIN course c
ON t.dept_id = c.dept_id
UNION
SELECT t.name AS teacher_name,
       c.course_title
FROM teacher t
RIGHT JOIN course c
ON t.dept_id = c.dept_id;

-- 25. Teachers and students in the same department, including unmatched rows
SELECT t.name AS teacher_name,
       s.name AS student_name
FROM teacher t
LEFT JOIN student s
ON t.dept_id = s.dept_id
UNION
SELECT t.name AS teacher_name,
       s.name AS student_name
FROM teacher t
RIGHT JOIN student s
ON t.dept_id = s.dept_id;
