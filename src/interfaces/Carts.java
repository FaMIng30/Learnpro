package interfaces;

import bean.Cartiterm;

public interface Carts {
    void delIterm(Integer ID);
    void addIterm(Cartiterm iterm);
    void updateCount(Integer ID,Integer itermcounts);

}
