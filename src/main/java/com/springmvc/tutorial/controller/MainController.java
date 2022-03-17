package com.springmvc.tutorial.controller;

import com.springmvc.tutorial.model.Book;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MainController {

    @RequestMapping("/")
    public String init() {
        return "index"; // index.jsp
    }

    // 2. ModelAndView.class
    // @RequestMapping("/add")
    // public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
        
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("/result");
    //     modelAndView.addObject("name", request.getParameter("name"));
    //     modelAndView.addObject("author", request.getParameter("author"));

    //     return modelAndView;
    // }

    // 3. RequestParam 방식, HttpServletRequest보다 간소화된 형태
    // @RequestMapping("/add")
    // public ModelAndView add(@RequestParam("name") String name, @RequestParam("author") String author) {

    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("result");

    //     modelAndView.addObject("name", name);
    //     modelAndView.addObject("author", author);

    //     return modelAndView;
    // }

    // 4. JSON 객체 반환 방식, @Controller -> @RestController로 변경
    // @RestController = @Controller + @ResponseBody
    @RequestMapping(value="/get", method=RequestMethod.GET)
    public Book getBook(@RequestParam("name") String name, @RequestParam("author") String author) {
        
        // Service(비지니스 로직) -> DAO(직접 DB접근)
        // DB에서 받은 Book 데이터
        // 비지니스 로직 및 DB 처리 후, JAVA(JSON) 객체 반환

        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        return book;
    }
    

}
