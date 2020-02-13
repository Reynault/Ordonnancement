package solve.filter;

import machine.Machine;

import java.util.List;

public class FirstPropertyFilter implements Filter{
    @Override
    public boolean isValid(List<Machine> machines) {
        boolean res = true;
        double end1, end2;
        double deb1, deb2;
        if(machines.size() >= 2) {
            Machine m1 = machines.get(0);
            Machine m2 = machines.get(1);
            if(m1.getTasks().size() >= 1 && m2.getTasks().size() >= 1) {
                end1 = m1.getEndTime();
                end2 = m2.getEndTime();
                deb1 = end1 - m1.getLastTask().getP();
                deb2 = end2 - m1.getLastTask().getP();
                if ((deb1 > end1) || (deb2 > end2)) res = false;
            }
        }
        return res;
    }
}
