package jpabook.jpashop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello") // hello 라는 창으로 가면 아래 함수가 실행됨
    public String hello(Model model){
        model.addAttribute("data","hello@!@");
        return "hello"; // resources/template/hello.html로 Model정보랑 뷰를 넘겨줌
    }

}
