package fr.dimitri.clientbiblio;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ClientBiblio {


        public static void main(String[] args) throws NamingException {
            InitialContext ic = new InitialContext();
            //IGestionLivre bs = (IGestionLivre) ic.lookup(IGestionLivre.class.getName());
        }
    }
