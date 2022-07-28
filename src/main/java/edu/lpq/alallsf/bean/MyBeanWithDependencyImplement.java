package edu.lpq.alallsf.bean;

import edu.lpq.alallsf.AlAllSfApplication;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
    private final Log LOGGER = LogFactory.getLog(AlAllSfApplication.class);
    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Ingreso al método printWithDependency");
        int numero  = 1;
        LOGGER.debug("Parm: numero = " + numero);
        System.out.println(">>>>> MyBeanWithDependencyImplement: " + myOperation.sum(numero));
    }
}
