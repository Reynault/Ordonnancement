package solve.filter;

import machine.Machine;

import java.util.List;

/**
 * Filtre qui laisse tout passer
 */
public class SimpleFilter implements Filter{
    @Override
    public boolean isValid(List<Machine> machines) {
        return true;
    }
}
