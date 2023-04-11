package fr.meetup.ddd.container_port.transport.inspection.adapter;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import feign.Feign;
import feign.RequestLine;
import feign.jackson.JacksonEncoder;

public interface InspectionHttpClient {

    static InspectionHttpClient baseUrl(String url) {
        return Feign.builder()
                .encoder(new JacksonEncoder())
                .target(InspectionHttpClient.class, url);
    }

    @RequestLine("POST /inspections")
    void postInspections(RequestInspection request);

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    record RequestInspection(
        String portId,
        String portContactEmail,
        String containerNumber,
        String dockNumber) {}

}
