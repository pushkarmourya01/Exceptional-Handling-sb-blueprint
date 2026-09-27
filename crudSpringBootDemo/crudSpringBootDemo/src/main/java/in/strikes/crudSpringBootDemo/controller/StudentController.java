package in.strikes.crudSpringBootDemo.controller;


import in.strikes.crudSpringBootDemo.DTO.StudentRequestDTO;
import in.strikes.crudSpringBootDemo.DTO.StudentResponseDTO;
import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/bacha")

public class StudentController {

    //contructor injection rahter than autowired we use manual Good Pracitse of Coding
    private StudentService studentService;
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    //create sutdent to get the student request and post into DTO.....
    //use @Valid and Request Body annotations

    @PostMapping
    public ResponseEntity<StudentResponseDTO> createStudent(
            @Valid @RequestBody StudentRequestDTO studentRequestDTO) {

        StudentResponseDTO createStudent =
                studentService.createStudent(studentRequestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createStudent);
    }
}
