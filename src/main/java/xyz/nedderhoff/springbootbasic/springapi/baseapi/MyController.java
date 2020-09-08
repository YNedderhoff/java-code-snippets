package xyz.nedderhoff.springbootbasic.springapi.baseapi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    private final MyService service;

    @Autowired
    public MyController(MyService service) {
        this.service = service;
    }

    @GetMapping("get")
    public  @ResponseBody String get() {
        Optional<String> s = service.get();
        if (s.isPresent()){
            return s.get();
        } else {
            throw new InternalError("service returned empty object");
        }
    }

    @PostMapping("test")
    public @ResponseBody String post1(@RequestBody RequestObj1 body){
        return "done";
    }


    private static class RequestObj1 {
        final String myString;

        private RequestObj1(String myString) {
            this.myString = myString;
        }

        public String getMyString() {
            return myString;
        }
    }
}
