package top.kwseeker.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import top.kwseeker.demo.utils.Person;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonController {

    @RequestMapping("/")
    public String index(Model model){       // 通过Model往Thymeleaf模板添加属性值
        Person single = new Person("aa",11);

        List<Person> people = new ArrayList<>();
        Person p1 = new Person("xx",11);
        Person p2 = new Person("yy",22);
        Person p3 = new Person("zz",33);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);

        return "index";
    }

}
