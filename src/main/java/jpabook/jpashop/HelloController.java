package jpabook.jpashop;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model)  {
        // 이 모델에다가 데이터 실어서 뷰로 넘긴다.
        model.addAttribute("data","hello!!");
        return "hello"; // 이 return은 화면이름이다.
    }
}
