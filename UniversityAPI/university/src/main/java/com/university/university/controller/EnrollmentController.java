package com.university.university.controller;
import com.university.university.entity.Enrollment;
import com.university.university.entity.EnrollmentId;
import com.university.university.repository.EnrollmentRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController extends CrudController<Enrollment, EnrollmentId> {
    public EnrollmentController(EnrollmentRepository repo) {
        super(repo, EnrollmentController::parseId, (entity, id) -> entity.setId(id));
    }
    private static EnrollmentId parseId(String value) {
        String[] parts = value.split("-", -1);
        if (parts.length != 2) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Use studentId-courseId, for example 1-10");
        try { return new EnrollmentId(Integer.valueOf(parts[0]), Integer.valueOf(parts[1])); }
        catch (NumberFormatException e) { throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "IDs must be integers"); }
    }
}
