package com.ltp.workbook;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class WorkbookController {
    
    @GetMapping("/")
    public ModelAndView getShows() {
        Map<String, Show> model = new HashMap<String, Show>();
        Show show = new Show("Breaking Bad", "Ozymandias", 10.0);
        Show show1 = new Show("Attack on Titan", "Hero", 9.9);
        Show show2 = new Show("Attack on Titan", "Perfect Game", 9.9);
        Show show3 = new Show("Star Wars: The Clone Wars", "Victory and Death", 9.9);
        Show show4 = new Show("Mr. Robot", "407 Proxy Authentication Required", 9.9);

        model.put("show", show);
        model.put("show1", show1);
        model.put("show2", show2);
        model.put("show3", show3);
        model.put("show4", show4);


        return new ModelAndView("shows", model);
    }

}
