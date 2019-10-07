package fr.dimitri.stateless;

import javax.ejb.Stateless;

@Stateless
public class BeanStateless implements IBeanStateless {
    @Override
    public String salut(String name) {
        return "Salut " + name;
    }
}
