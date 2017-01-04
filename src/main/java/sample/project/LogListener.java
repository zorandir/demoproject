package sample.project;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LogListener {

    @EventListener
    void log(DomainEvent event){
        System.out.print(event.getException());
    }
}
