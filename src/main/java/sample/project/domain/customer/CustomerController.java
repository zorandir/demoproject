package sample.project.domain.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sample.project.domain.customer.CreateCustomerCommand;
import sample.project.domain.customer.CreateCustomerHandler;
import sample.project.domain.customer.CustomerCreatedEvent;

import java.util.HashMap;

/**
 * Created by zorandir on 03/01/17.
 */
@Controller
public class CustomerController {

    @Autowired
    CreateCustomerHandler createCustomerHandler;

    @Autowired
    ApplicationEventPublisher publisher;

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> helloWorld() {
        return new ResponseEntity<>("{\"name\": 1}", HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/customer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<?> createCustomer(@RequestBody CreateCustomerCommand command) {
        try{
            createCustomerHandler.handle(command);
            publisher.publishEvent(new CustomerCreatedEvent(command.getResult()));
            return new ResponseEntity<>(command.getResult(), HttpStatus.OK);
        }catch (Exception e){
            publisher.publishEvent(new CustomerCreatedEvent(e));
            final HashMap<String, Object> result = new HashMap<>();
            result.put("error", "Deu merda");
            result.put("code", "5001");
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
