package fr.dimitri.stateful;

import javax.ejb.Remote;

@Remote
public interface IBeanStateful {
    String salut(String name);

    String resalut();
}
