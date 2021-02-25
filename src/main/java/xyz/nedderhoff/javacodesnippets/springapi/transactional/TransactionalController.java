package xyz.nedderhoff.javacodesnippets.springapi.transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.google.common.collect.ImmutableList;

@Controller
public class TransactionalController {

    @Autowired
    TransactionalRepository transactionalRepository;

    @GetMapping("/executetransaction")
    public String executeTransaction(){
        TransactionalEntity entity1 = new TransactionalEntity("Foo", "Bar");
        //TransactionalEntity entity2 = new TransactionalEntity("Foo", "Bar");
        TransactionalEntity entity2 = new TransactionalEntity("Zoo", "Car");
        transactionalRepository.store(ImmutableList.of(entity1, entity2));
        return "yeah!";
    }
}
