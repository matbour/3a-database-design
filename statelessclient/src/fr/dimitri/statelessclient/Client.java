package fr.dimitri.statelessclient;

import fr.dimitri.stateful.IBeanStateful;

import javax.naming.InitialContext;
import javax.naming.NamingException;

class Client {

    public static void main(String[] args) throws NamingException {
        InitialContext ic = new InitialContext();
        IBeanStateful bs = (IBeanStateful) ic.lookup(IBeanStateful.class.getName());
        System.out.println(bs.salut("dimitri"));
        System.out.println(bs.resalut());
    }
}