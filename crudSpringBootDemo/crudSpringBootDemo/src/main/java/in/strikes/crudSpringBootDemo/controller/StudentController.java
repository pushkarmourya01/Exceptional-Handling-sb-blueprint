package in.strikes.crudSpringBootDemo.controller;


import in.strikes.crudSpringBootDemo.entity.Student;
import in.strikes.crudSpringBootDemo.service.StudentService;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
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



}
