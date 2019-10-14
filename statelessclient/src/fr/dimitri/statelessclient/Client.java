package fr.dimitri.statelessclient;

import fr.dimitri.biblio.IGestionLivre;
import fr.dimitri.stateful.IBeanStateful;

import javax.naming.InitialContext;
import javax.naming.NamingException;

class Client {

    public static void main(String[] args) throws NamingException {
        InitialContext ic = new InitialContext();
        IBeanStateful bs = (IBeanStateful) ic.lookup(IBeanStateful.class.getName());

        IGestionLivre gestion = (IGestionLivre) ic.lookup(IGestionLivre.class.getName());
        gestion.nouveauLive("1123", "Ma cousine rachelle");
        System.out.println(bs.salut("dimitri"));
        System.out.println(bs.resalut());

    }
}