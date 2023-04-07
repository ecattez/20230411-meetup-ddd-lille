package fr.meetup.ddd.container_port.transport;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static fr.meetup.ddd.container_port.transport.TransportFixtures.ID_CONTENEUR;
import static fr.meetup.ddd.container_port.transport.TransportFixtures.ID_QUAI;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DéposerConteneurTest {

    @Mock
    ConteneurRepository conteneurRepository;
    @Mock
    EventPublisher eventPublisher;
    @Captor
    ArgumentCaptor<Conteneur> conteneurCaptor;
    @InjectMocks
    DéposerConteneur déposerConteneur;

    @Test
    void déposer_un_conteneur_sur_un_quai() {
        when(conteneurRepository.fromId(ID_CONTENEUR))
                .thenReturn(Optional.of(new Conteneur(ID_CONTENEUR)));

        déposerConteneur.execute(ID_CONTENEUR, ID_QUAI);

        InOrder inOrder = inOrder(conteneurRepository, eventPublisher);

        inOrder.verify(conteneurRepository)
                .save(conteneurCaptor.capture());
        inOrder.verify(eventPublisher)
                .publish(ConteneurDéposé.of(ID_CONTENEUR, ID_QUAI));

        Conteneur conteneur = conteneurCaptor.getValue();

        assertThat(conteneur.déposéSur())
                .contains(ID_QUAI);
    }
}