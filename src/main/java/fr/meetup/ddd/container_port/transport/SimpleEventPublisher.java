package fr.meetup.ddd.container_port.transport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SimpleEventPublisher implements EventPublisher {

    private Map<Class<?>, List<Consumer<?>>> consumers = new HashMap<>();

    private <T> List<Consumer<T>> consumersOf(T event) {
        return consumers.get(event.getClass()).stream()
                .map(c -> (Consumer<T>) c)
                .collect(Collectors.toList());
    }

    @Override
    public <T> void publier(T event) {
        consumersOf(event).forEach(consumer -> consumer.accept(event));
    }

    @Override
    public <T> void souscrireA(Class<T> event, Consumer<T> consumer) {
        consumers.computeIfAbsent(event, (key) -> new ArrayList<>())
                .add(consumer);
    }

}
