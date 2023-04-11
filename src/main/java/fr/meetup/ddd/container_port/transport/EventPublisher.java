package fr.meetup.ddd.container_port.transport;

import java.util.function.Consumer;

public interface EventPublisher {

    <T> void publier(T event);

    <T> void souscrireA(Class<T> event, Consumer<T> consumer);
}
