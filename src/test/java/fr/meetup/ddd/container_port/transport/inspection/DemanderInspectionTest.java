package fr.meetup.ddd.container_port.transport.inspection;

import fr.meetup.ddd.container_port.transport.EventPublisher;
import fr.meetup.ddd.container_port.transport.SimpleEventPublisher;
import fr.meetup.ddd.container_port.transport.quai.ConteneurDéposé;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static fr.meetup.ddd.container_port.transport.TransportFixtures.ID_CONTENEUR;
import static fr.meetup.ddd.container_port.transport.TransportFixtures.ID_QUAI;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DemanderInspectionTest {

    @Spy
    EventPublisher eventPublisher = new SimpleEventPublisher();
    @Mock
    InspectionDemandeur inspectionDemandeur;
    @InjectMocks
    DemanderInspection demanderInspection;

    @Test
    void inspecter_un_conteneur_à_quai() {
        // when
        eventPublisher.publier(ConteneurDéposé.of(ID_CONTENEUR, ID_QUAI));

        // then
        verify(inspectionDemandeur)
                .demanderInspection(ID_CONTENEUR, ID_QUAI);
    }
}
