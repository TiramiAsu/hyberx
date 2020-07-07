/*
 * 
 * 
 * 
 * 
 * 
 * &copy;Asu
 * 
 */
package tw.com.hyberx.controller;

import static tw.com.hyberx.utils.enums.InfoAPI._ADD;
import static tw.com.hyberx.utils.enums.InfoAPI._CANCEL;
import static tw.com.hyberx.utils.enums.InfoAPI._FIND;
import static tw.com.hyberx.utils.enums.InfoAPI._MODIFY;
import static tw.com.hyberx.utils.enums.InfoAPI._REMOVE;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tw.com.hyberx.controller.vo.StudentVo;
import tw.com.hyberx.model.entity.BasicInfo;
import tw.com.hyberx.model.entity.Student;
import tw.com.hyberx.service.BasicInfoService;
import tw.com.hyberx.service.StudentService;
import tw.com.hyberx.utils.ControllerUtil;
import tw.com.hyberx.utils.SpringUtils;

/**
 * [Student Controller]
 * <p>
 * 
 * @author  Asu
 * @since   2020-06-06 01:23
 * @version 2020-06-26 23:32 [Asu] 串接 Basic Info
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    public static final String _NAME = "student";

    @Autowired
    public StudentService studentService;

    @Autowired
    public BasicInfoService basicInfoService;

    public void initService() {
        studentService = (studentService == null) ? SpringUtils.getBean(StudentService.class) : studentService;
        basicInfoService = (basicInfoService == null) ? SpringUtils.getBean(BasicInfoService.class) : basicInfoService;
    }

    /* list 假資料
    static List<Student> students = new ArrayList<>();
    
    static {
        Student sd1 = new Student("Anita", 21);
        sd1.setId(1);
        Student sd2 = new Student("Asia", 19);
        sd2.setId(2);
        students.add(sd1);
        students.add(sd2);
    }
    */

//    @GetMapping("/search") // URL request 進來
    @GetMapping
    public String input(Model model) { // model 要傳給 JSP from
        
        /* list 假資料
        Student student = new Student();
//      student.setName("Anita"); // 可傳入值在表單中
        model.addAttribute("student", student); // 屬性名稱為spring form 的 modelAttribute
        model.addAttribute("students", students);
        model.addAttribute("action", "add");
        */

        /** 正式串接 DB */
        
        // initial Service
        initService();
        
        model.addAttribute("studentVo", new StudentVo()); // 屬性名稱為spring form 的 modelAttribute
        model.addAttribute("students", studentService.query());
        
        // 加入 API
//        model.addAttribute("action", "add");
        ControllerUtil.setAPI(model, _NAME, _ADD, _CANCEL, _FIND, _REMOVE);
        return "jsp/test/student";
    }

    @PostMapping("/add") // Form request 進來
    public String add(@ModelAttribute StudentVo studentVo) {
        
        /* list 假資料
        Long id = 1L;
        if (students.size() != 0) {
            id += students.stream().mapToLong(s -> s.getId()).max().getAsLong();
        }
        student.setId(id);
        students.add(student);
        students.stream().forEach(System.out::println);
        */

        /** 正式串接 DB */
        
        // initial Service
        initService();
        
        basicInfoService.create(studentVo.getBasicInfo());
        studentService.create(studentVo.getStudent());
        return "redirect:./search";
    }

    @GetMapping("/find/{id}")
    public String find(@PathVariable Long id, Model model) {

        /* list 假資料
        Student student = students.stream().filter(s -> s.getId() == id).findFirst().get();
        
        model.addAttribute("student", student);
        model.addAttribute("students", students);
        model.addAttribute("action", "update");
        */

        /** 正式串接 DB */
        
        // initial Service
        initService();
        
        model.addAttribute("studentVo", new StudentVo(studentService.find(id)));
        model.addAttribute("students", studentService.query());

        // 加入 API
//        model.addAttribute("action", "update");
        ControllerUtil.setAPI(model, _NAME, _MODIFY, _CANCEL, _FIND, _REMOVE);
        return "test/student";
    }

    @PostMapping("/modify")
    public String update(@ModelAttribute StudentVo studentVo) {
        
        /* list 假資料
        Student stu = students.stream().filter(s -> s.getId() == student.getId()).findFirst().get();
        stu.setName(student.getName());
        stu.setAge(student.getAge());
        */

        /** 正式串接 DB */
        
        // initial Service
        initService();
        
        Student oriStudent = studentService.find(studentVo.getStudent().getId());
        BasicInfo oriBasicInfo = oriStudent.getBasicInfo();
        if (!oriStudent.equals(null)) {
            oriBasicInfo.setName(oriBasicInfo.getName().equals(oriBasicInfo.getName()) ? studentVo.getBasicInfo().getName() : oriBasicInfo.getName());
            oriBasicInfo.setAge(oriBasicInfo.getAge().equals(oriBasicInfo.getAge()) ? studentVo.getBasicInfo().getAge() : oriBasicInfo.getAge());
            oriBasicInfo.setTimeModify(new Date());
            oriStudent.setTimeModify(new Date());
        }
        oriStudent.setBasicInfo(oriBasicInfo);
        
        studentService.update(oriStudent);
        return "redirect:./search";
    }

    @GetMapping("/remove/{id}")
    public String delete(@PathVariable("id") Long id) {
        
        /* list 假資料
        Student student = students.stream().filter(s -> s.getId() == id).findFirst().get();
        students.remove(student);
        */

        /** 正式串接 DB */
        
        // initial Service
        initService();
        
        Student oriStudent = studentService.find(id);
        if (oriStudent.equals(null)) {
            System.out.println(">>> delete failed <<<");
        } else {
            studentService.delete(id);
        }
        return "redirect:../search";
    }
}