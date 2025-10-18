package com.app.controller.apis;

import com.app.domain.vo.ProductVO;
import com.app.domain.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ex/*")
@Slf4j
public class ExampleController {

    @GetMapping("/ex01") //http://localhost:10000/ex/ex01
    public void ex01(String name, int age){
        log.info("경로 요청");
        log.info(name);
        log.info("나이: {}", age);
        log.info("만 나이: {}", age - 1);
    }

//  model: view로 데이터를 보내기 위한 객체
    @GetMapping("/ex02")
    public void ex02(@RequestParam String job, @RequestParam String name, Model model){
        model.addAttribute("name", name);
        model.addAttribute("job", job);
        log.info("직업: {}", job);
        log.info("이름: {}", name);
    }

//  이름 용돈을 받아서 용돈 - 5000원
    @GetMapping("/ex03")
    public void ex03(@RequestParam String name, @RequestParam int money){
        log.info("이름: {}", name);
        log.info("용돈: {}", money);
        log.info("남은 용돈: {}", money - 5000);
    }

//  ex04 컨트롤러를 이용하여
//  html을 생성 후 화면(form)을 이용해서 데이터를 받고
//  받은 데이터를 화면에 출력하기
    @GetMapping("/ex04")
    public void ex04(){
        log.info("요청");
    }

    @GetMapping("/ex05")
    public void ex05(UserVO userVO, Model model){
        model.addAttribute("name", userVO.getUserName());
        model.addAttribute("age", userVO.getUserAge());
        model.addAttribute("email", userVO.getUserEmail());
        model.addAttribute("phone", userVO.getUserPhone());
        log.info("전송했음");
    }

//    ProductVO를 생성 후 상품명과 가격을 받아서 화면에 출력하기
//    productName, productPrice
    @GetMapping("/ex06")
    public void ex06(){;}

    @PostMapping("/ex06")
    public String ex06Form(ProductVO productVO, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("productVO", productVO);
        return "/ex/ex07";
    }

    @GetMapping("/ex07")
    public void ex07(){;}
}
