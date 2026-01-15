package uz.ems.testcicd.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import uz.ems.testcicd.service.TasbehService;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class TasbehController {

    private final TasbehService tasbehService;

    @GetMapping("/tasbeh")
    public String page(HttpSession session) {
        if (session.getAttribute("USER_ID") == null)
            return "redirect:/login";
        return "tasbeh";
    }

    @ResponseBody
    @GetMapping("/tasbeh/counts")
    public Map<String, Object> counts(HttpSession session) {
        return tasbehService.getCounts((Long) session.getAttribute("USER_ID"));
    }

    @ResponseBody
    @PostMapping("/tasbeh/increase")
    public Map<String, Long> increase(HttpSession session) {
        return tasbehService.increase((Long) session.getAttribute("USER_ID"));
    }
}
