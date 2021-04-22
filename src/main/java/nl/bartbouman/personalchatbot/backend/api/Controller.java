package nl.bartbouman.personalchatbot.backend.api;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class Controller {

//    @Value("${OPENAI_TOKEN}")
    static String OPENAI_TOKEN = "sk-pVbV2vxnhDL4MPvCAbfc4gN6iKr71IjVTctRKou3";

    @PostMapping("completion")
    public CompletionResult createCompletion() {

        String token = OPENAI_TOKEN;
        OpenAiService service = new OpenAiService(token);

        CompletionRequest completionRequest = CompletionRequest.builder()
                .prompt("Q: help me to see clearly. \n" +
                        "A: go see an opticien! \n" +
                        "Q: help me feel better. \n" +
                        "A: ")
                .maxTokens(60)
                .echo(true)
                .build();
        return service.createCompletion("ada", completionRequest);
    }
}
