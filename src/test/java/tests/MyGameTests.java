package tests;

import junit.framework.Assert;
import org.junit.Test;
import ua.kpi.*;
public class MyGameTests {

    @Test
    public void testGetersSetersModel() {
        //
        Model model = new Model();
        model.setPrevNum(0);
        model.setNextNum(0);
        model.setPrevNum(0);
        int num = model.getNumGuess() + model.getNextNum() + model.getPrevNum();
        Assert.assertEquals(num, 0);
    }

}
