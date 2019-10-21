package fr.dimitrimathieu.biblio.exceptions;

import fr.dimitrimathieu.biblio.entities.Emprunteur;

public class NbMaxEmpruntsAtteint extends Exception {
    public NbMaxEmpruntsAtteint(Emprunteur emprunteur, int nbmaxemprunts) {
        super(
            String.format(
                "L'emprunteur %d (%s) a atteint le nombre maximum d'emprunt autorisés (%d)",
                emprunteur.getNumemp(),
                emprunteur.getNom(),
                nbmaxemprunts
            )
        );
    }
}
