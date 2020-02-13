package solve.filter;

import machine.Machine;
import task.Task;

import java.util.List;

public class SecondPropertyFilter implements Filter{
    @Override
    public boolean isValid(List<Machine> machines) {
        boolean res = true;
        double currentD;
        for(Machine m: machines){
            currentD = 0;
            for(Task t: m.getTasks()){
                if(currentD > t.getD()) {
                    res = false;
                    break;
                }
                currentD = t.getD();
            }
        }
        return res;
    }
}
