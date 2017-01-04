package sample.project.domain.customer;

import org.springframework.stereotype.Component;

@Component
public class CreateCustomerHandler {

    public void handle(CreateCustomerCommand command) throws Exception {
        final Customer customer = new Customer();
        customer.setId(123);
        customer.setName(command.getName());
        command.setResult(customer);
        throw new Exception("test");
    }

}