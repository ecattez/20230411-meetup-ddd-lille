package fr.meetup.ddd.container_port.transport.inspection.adapter;

import fr.meetup.ddd.container_port.transport.IdConteneur;
import fr.meetup.ddd.container_port.transport.IdQuai;
import fr.meetup.ddd.container_port.transport.inspection.InspectionDemandeur;

public class HttpInspectionDemandeur implements InspectionDemandeur {

    private final InspectionHttpClient inspectionClient;

    public HttpInspectionDemandeur(InspectionHttpClient inspectionClient) {
        this.inspectionClient = inspectionClient;
    }

    @Override
    public void demanderInspection(IdConteneur idConteneur, IdQuai idQuai) {
        InspectionHttpClient.RequestInspection requestInspection = new InspectionHttpClient.RequestInspection(
                "PORT_ABCD",
                "transport@port-de-dunkerque.com",
                idConteneur.value(),
                idQuai.value());

        inspectionClient.postInspections(requestInspection);
    }
}
