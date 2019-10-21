package fr.dimitrimathieu.biblioclient;

import fr.dimitrimathieu.biblio.exceptions.LivreDejaEmprunte;
import fr.dimitrimathieu.biblio.exceptions.NbMaxEmpruntsAtteint;
import fr.dimitrimathieu.biblio.interfaces.IGestionEmprunt;
import fr.dimitrimathieu.biblio.interfaces.IGestionLivre;
import fr.dimitrimathieu.biblio.interfaces.IInfosLivre;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientBiblio {
    private IGestionLivre gestionLivre;
    private IGestionEmprunt gestionEmprunt;
    private IInfosLivre infosLivre;

    public static void main(String[] args) {
        ClientBiblio app = new ClientBiblio();
        app.initialisation();
        // app.remplir();

        System.out.println("Test de la création d'un livre");
        app.testListerLivres();
        app.testCreationLivre();
        app.testListerLivres();
        System.out.println();

        System.out.println("Test de la suppression d'un livre");
        app.testSuppressionLivre();
        app.testListerLivres();
        System.out.println();

        System.out.println("Test de la récupération d'un titre de livre par son ISBN avec une requête nommée @NamedQuery");
        app.testRecuperationParIsbn("555");
        System.out.println();

        System.out.println("Test de la liste des livre avec une requête nommée @NamedQuery");
        app.testListerLivres();
        System.out.println();

        System.out.println("Test d'un emprunt valide (1, \"666\")");
        app.testEmprunt(1, "666");
        app.testListerLivres();
        System.out.println();

        System.out.println("Test d'un rendu valide (1, \"666\")");
        app.testRendu("666");
        app.testListerLivres();
        System.out.println();

        System.out.println("Test du nombre max d'emprunt atteint");
        app.testEmprunt(1, "111");
        app.testEmprunt(1, "222");
        app.testEmprunt(1, "333");
        app.testListerLivres();

        app.testEmprunt(1, "444");

        app.testRendu("111");
        app.testRendu("222");
        app.testRendu("333");
        app.testListerLivres();
        System.out.println();

        System.out.println("Test du conflit d'emprunt");
        app.testEmprunt(1, "111");
        app.testEmprunt(2, "111");
        app.testRendu("111");
        app.testListerLivres();
        System.out.println();
    }

    private void initialisation() {
        try {
            InitialContext initialContext = new InitialContext();
            gestionLivre = (IGestionLivre) initialContext.lookup(IGestionLivre.class.getName());
            gestionEmprunt = (IGestionEmprunt) initialContext.lookup(IGestionEmprunt.class.getName());
            infosLivre = (IInfosLivre) initialContext.lookup(IInfosLivre.class.getName());
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private void testCreationLivre() {
        System.out.println("> Création du livre (777, \"Test livre\", 1)");
        gestionLivre.nouveauLivre("777", "Test livre");
    }

    private void testSuppressionLivre() {
        System.out.println("> Suppression du livre 777");
        gestionLivre.suppressionLivre("777");
    }

    private void testRecuperationParIsbn(String isbn) {
        System.out.printf("> Récupération du livre %s%n", isbn);
        System.out.println(infosLivre.trouverParIsbn(isbn).toString());
    }

    private void testListerLivres() {
        System.out.println("> Récupération de la liste des livres");
        infosLivre.lister().forEach(livre -> System.out.println(livre.toString()));
    }

    private void testEmprunt(int num_emprunteur, String isbn) {
        System.out.printf("> Emprunt du livre %s par l'emprunteur numéro %d%n", isbn, num_emprunteur);
        try {
            gestionEmprunt.emprunter(num_emprunteur, isbn);
        } catch (NbMaxEmpruntsAtteint | LivreDejaEmprunte ex) {
            System.out.println("Erreur: " + ex.getMessage());
        }
    }

    private void testRendu(String isbn) {
        System.out.printf("> Rendu du livre %s%n", isbn);
        gestionEmprunt.rendre(isbn);
    }
}
