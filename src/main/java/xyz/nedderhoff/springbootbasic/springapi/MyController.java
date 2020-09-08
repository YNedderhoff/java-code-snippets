package xyz.nedderhoff.springbootbasic.springapi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final MyService service;

    @Autowired
    public MyController(MyService service) {
        this.service = service;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {
        Optional<String> s = service.get();
        if (s.isPresent()){
            return s.get();
        } else {
            throw new InternalError("service returned empty object");
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String post1(@RequestBody RequestObj1 body){
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
