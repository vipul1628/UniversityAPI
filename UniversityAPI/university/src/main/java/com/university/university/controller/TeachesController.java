package com.university.university.controller;
import com.university.university.entity.Teaches;
import com.university.university.entity.TeachesId;
import com.university.university.repository.TeachesRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.function.BiConsumer;

@RestController
@RequestMapping("/api/teaches")
public class TeachesController extends CrudController<Teaches, TeachesId> {
    public TeachesController(TeachesRepository repo) {
        super(repo, TeachesController::parseId, (entity, id) -> entity.setId(id));
    }
    private static TeachesId parseId(String value) {
        String[] parts = value.split("-", -1);
        if (parts.length != 2) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Use teacherId-courseId, for example 1-10");
        try { return new TeachesId(Integer.valueOf(parts[0]), Integer.valueOf(parts[1])); }
        catch (NumberFormatException e) { throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "IDs must be integers"); }
    }
}
