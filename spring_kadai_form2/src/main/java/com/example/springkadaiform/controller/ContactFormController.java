package com.example.springkadaiform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

import jakarta.validation.Valid;

@Controller
public class ContactFormController {

    @GetMapping("/form")
    public String showForm(@ModelAttribute("contactForm") ContactForm contactForm) {
        return "contactFormView";
    }

    @PostMapping("/form")
    public String submitForm(@Valid @ModelAttribute("contactForm") ContactForm contactForm, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.contactForm", result);
            redirectAttributes.addFlashAttribute("contactForm", contactForm);
            return "redirect:/form"; // リダイレクトで元のフォームに戻る
        }
        return "confirmView";
    }
}
