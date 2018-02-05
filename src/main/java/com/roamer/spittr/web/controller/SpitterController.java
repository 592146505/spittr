package com.roamer.spittr.web.controller;

import com.roamer.spittr.pojo.Spitter;
import com.roamer.spittr.dao.SpitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


/**
 * @author roamer
 * @version V1.0
 * @date 2018/1/11
 */
@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("spitter", new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @Validated Spitter spitter, Errors errors) {
        //Spitter参数添加了@Valid注解，这会告知Spring，需要确保这个对象满足校验限制
        //校验不通过则返回注册表单
        if (errors.hasErrors()) {
            return "registerForm";
        }
        spitterRepository.save(spitter);
        //当InternalResourceViewResolver看到视图格式中的“redirect:”前缀时，
        //它就知道要将其解析为重定向的规则，而不是视图的名称
        //“forward:”作为前缀时，请求将会前往（ forward）指定的URL路径，而不再是重定向
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/register2", method = RequestMethod.POST)
    public String processRegistration2(
            @RequestParam("profilePicture") MultipartFile profilePicture, @Validated Spitter spitter, Errors errors) {
        //Spitter参数添加了@Valid注解，这会告知Spring，需要确保这个对象满足校验限制
        //校验不通过则返回注册表单
        if (errors.hasErrors()) {
            return "registerForm";
        }
        spitterRepository.save(spitter);
        //当InternalResourceViewResolver看到视图格式中的“redirect:”前缀时，
        //它就知道要将其解析为重定向的规则，而不是视图的名称
        //“forward:”作为前缀时，请求将会前往（ forward）指定的URL路径，而不再是重定向
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "{username}", method = RequestMethod.GET)
    public String showSpitterProfile(
            @PathVariable String username, Model model) {
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute("spitter", spitter);
        return "profile";
    }
}
