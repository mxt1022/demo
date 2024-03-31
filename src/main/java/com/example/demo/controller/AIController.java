package com.example.demo.controller;

import com.example.demo.util.AiUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class AIController {
    @RequestMapping(value = "/img",method = RequestMethod.POST)
    public String img(@RequestParam("file")MultipartFile file) throws IOException {
        return AiUtils.img(file);
    }

    @RequestMapping(value = "/word",method = RequestMethod.POST)
    public String word(@RequestParam("file") MultipartFile file) throws IOException {
        return AiUtils.word(file);
    }

   @RequestMapping(value = "/nlp",method = RequestMethod.GET)
    public String nlp(@RequestParam("text") String text){
       return AiUtils.nlp(text);
   }
}
