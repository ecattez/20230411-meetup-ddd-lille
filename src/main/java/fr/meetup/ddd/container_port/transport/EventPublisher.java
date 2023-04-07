package fr.meetup.ddd.container_port.transport;

public interface EventPublisher {

    void publish(Object event);

}
