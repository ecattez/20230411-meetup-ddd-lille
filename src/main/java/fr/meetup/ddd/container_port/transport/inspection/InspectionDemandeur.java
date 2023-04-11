package fr.meetup.ddd.container_port.transport.inspection;

import fr.meetup.ddd.container_port.transport.IdConteneur;
import fr.meetup.ddd.container_port.transport.IdQuai;

public interface InspectionDemandeur {
    void demanderInspection(IdConteneur idConteneur, IdQuai idQuai);
}
