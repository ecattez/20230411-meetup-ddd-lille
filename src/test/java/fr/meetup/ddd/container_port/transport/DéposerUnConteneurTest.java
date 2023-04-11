package fr.meetup.ddd.container_port.transport;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DéposerUnConteneurTest {

    IdConteneur idConteneur = new IdConteneur("8");
    NumeroQuai numeroQuai = new NumeroQuai("12");

    @Mock
    ConteneurRepository conteneurRepository;
    @InjectMocks
    DépotDeConteneur dépotDeConteneur;

    @Test
    void le_conteneur_n_existe_pas() {
        when(conteneurRepository.findById(any()))
                .thenReturn(Optional.empty());

        DéposerConteneur commande = new DéposerConteneur(idConteneur, numeroQuai);

        ConteneurNaPasEteTrouvé evenement = (ConteneurNaPasEteTrouvé) dépotDeConteneur.déposerUnConteneur(commande);

        assertThat(evenement.idConteneur().value()).isEqualTo("8");
    }

    @Test
    void déposer_un_conteneur() {
        when(conteneurRepository.findById(any()))
                .thenReturn(Optional.of(new Conteneur()));

        DéposerConteneur commande = new DéposerConteneur(idConteneur, numeroQuai);

        ConteneurDéposé evenement = (ConteneurDéposé) dépotDeConteneur.déposerUnConteneur(commande);

        assertThat(evenement.idConteneur().value()).isEqualTo("8");
        assertThat(evenement.numeroQuai().value()).isEqualTo("12");
    }

    @Test
    void inspecter_un_conteneur() {
        Conteneur conteneur = new Conteneur();

        when(conteneurRepository.findById(any()))
                .thenReturn(Optional.of(conteneur));

        ServiceDInspection serviceDInspection = mock(ServiceDInspection.class);
        InspecterConteneur commande = new InspecterConteneur(conteneurRepository, serviceDInspection, idConteneur);
        commande.execute();

        verify(serviceDInspection, times(1))
                .inspecter(conteneur);
    }
}
