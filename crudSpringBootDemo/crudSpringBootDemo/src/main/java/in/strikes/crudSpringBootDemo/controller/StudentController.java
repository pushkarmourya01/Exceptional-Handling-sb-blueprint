package in.strikes.crudSpringBootDemo.controller;


import in.strikes.crudSpringBootDemo.DTO.StudentRequestDTO;
import in.strikes.crudSpringBootDemo.DTO.StudentResponseDTO;
import in.strikes.crudSpringBootDemo.DTO.StudentUpdateRequestDTO;
import in.strikes.crudSpringBootDemo.DTO.StudentUpdateResponseDTO;
import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;
import jakarta.validation.Valid;
import org.hibernate.engine.spi.Resolution;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

 @GetMapping("/{id}")
     public ResponseEntity<StudentResponseDTO> getStud(@PathVariable Long id){
        StudentResponseDTO getstud = studentService.getStud(id);
     return ResponseEntity
             .status(HttpStatus.OK)
             .body(getstud);
 }
 @GetMapping // not require any parameter such as id or anything just student List give all the list of the students
    public ResponseEntity<List<StudentRequestDTO>> getAll(){
        List<StudentRequestDTO> studList = studentService.getAll();

//We're Taking list so return also must have such type
  return ResponseEntity
          .status(HttpStatus.OK)
          .body(studList);

 }
@PutMapping("/{id}")
    public ResponseEntity<StudentUpdateResponseDTO>
updateStud(@PathVariable Long id, @RequestBody StudentRequestDTO studentRequestDTO){
        StudentUpdateResponseDTO updateStud = studentService.updateStud(id, studentRequestDTO);

        return ResponseEntity.ok(updateStud);
}

 @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> deleStud(@PathVariable Long id){
        StudentResponseDTO deleStud = studentService.deleStud(id);

        return ResponseEntity.ok(deleStud);
 }

}
