package com.example.validate.ValidatingInput;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class VController implements WebMvcConfigurer {

    private static final Logger logger = LoggerFactory.getLogger(VController.class);
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }


    @GetMapping("/")
    public String show(Model model)
    {
        model.addAttribute("personForm",new Personform());
        return "Validation/form";
//    return "Validation/results";
    }

    @PostMapping("/")
    public String check(@Valid Personform personForm, BindingResult bindingResult,Model model)
    {

        logger.info(personForm.toString());

        model.addAttribute("personForm",personForm);
        model.addAttribute("fields",bindingResult.getAllErrors());
       Boolean a =  bindingResult.getAllErrors().contains("name");
       logger.info("a时"+a);
        if (bindingResult.hasErrors())
        {
            return "Validation/form";
        }
        return "Validation/results";
    }





}
