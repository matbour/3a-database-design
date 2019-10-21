package fr.dimitrimathieu.biblio.exceptions;

import fr.dimitrimathieu.biblio.entities.Livre;

public class LivreDejaEmprunte extends Exception {
    public LivreDejaEmprunte(Livre livre) {
        super(
            String.format(
                "Le livre %s (%s) a déjà été emprunté",
                livre.getIsbn(),
                livre.getTitre()
            )
        );
    }
}
