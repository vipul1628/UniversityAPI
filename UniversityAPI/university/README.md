# University CRUD API

Spring Boot REST API organized as six JPA entities, six Spring Data repositories, and six resource controllers for the University database tables.

## Database setup

Run [`database/schema.sql`](database/schema.sql) in MySQL. Configure the connection before starting the app:

```powershell
$env:DB_URL = "jdbc:mysql://localhost:3306/University"
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = "your-local-mysql-password"
```

The defaults use localhost, database `University`, and username `root`. The password defaults to empty; do not commit credentials to GitHub.

The teacher's SQL practice queries (filters, aggregates, grouping, joins, and unions) are in [`database/queries.sql`](database/queries.sql). Run that file in MySQL Workbench after creating the schema to display their results.

## Run locally

```powershell
.\mvnw.cmd spring-boot:run
```

The server runs at `http://localhost:8080`.

## Endpoints

Each resource supports `GET /api/{resource}` (list), `GET /api/{resource}/{id}` (one record), `POST /api/{resource}` (create), `PUT /api/{resource}/{id}` (replace/update), and `DELETE /api/{resource}/{id}` (delete).

| Resource | Database table | ID |
| --- | --- | --- |
| `/api/departments` | `department` | `deptId` |
| `/api/teachers` | `teacher` | `teacherId` |
| `/api/students` | `student` | `studentId` |
| `/api/courses` | `course` | `courseId` |
| `/api/teaches` | `teaches` | `id.teacherId` and `id.courseId` |
| `/api/enrollments` | `enrollment` | `id.studentId` and `id.courseId` |

For example, `GET /api/departments/1` returns one department. Entity JSON uses Java property names, such as `{"deptId":1,"deptName":"Computer Science","building":"A","budget":125000.00}`. Foreign keys are represented by nested objects; for example a student request can include `"department":{"deptId":1}`. `teaches` and `enrollments` use composite IDs in their `id` object.

Foreign key and duplicate key errors are returned by Spring as HTTP error responses. Insert parent rows before child rows and delete dependent rows before their parents.
