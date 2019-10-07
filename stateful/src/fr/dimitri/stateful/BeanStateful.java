package fr.dimitri.stateful;

import javax.ejb.Stateful;

@Stateful
public class BeanStateful implements IBeanStateful {
    private String name;

    @Override
    public String salut(String name) {
        this.name = name;
        return "Salut " + name;
    }

    @Override
    public String resalut() {
        return "Rs-salut " + this.name;
    }
}
