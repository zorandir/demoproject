package sample.project.domain.customer;

import sample.project.Command;

public class CreateCustomerCommand implements Command{
    private String name;
    private Customer result;

    public String getName() {
        return name;
    }

    public Customer getResult() {
        return result;
    }

    public void setResult(Customer result) {
        this.result = result;
    }
}
