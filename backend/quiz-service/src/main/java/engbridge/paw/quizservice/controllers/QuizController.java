package engbridge.paw.quizservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    @GetMapping
    public String getQuizzes() {
        return "This will return all quizzes.";
    }
}
