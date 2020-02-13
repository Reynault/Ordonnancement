package solve.filter;

import machine.Machine;

import java.util.List;

/**
 * Objet permettant de filtrer une planification possible
 * en enlevant celles qui ne respectent pas certaines conditions
 */
public interface Filter {
    /**
     * Méthode de filtrage
     * @param machines la planification à filtrer
     * @return Vrai si correct
     */
    boolean isValid(List<Machine> machines);
}
