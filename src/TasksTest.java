import org.junit.Assert;

import org.junit.Test;
import org.testng.annotations.DataProvider;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TasksTest {

    @Test
    public void testBeginTask() {
        //S = 3.14 * r * r
        //L = 2 * 3.14 * r
        assertEquals(new Tasks().BeginTask(1),new FirstTaskAnswer(3.14, 6.28));
        assertEquals(new Tasks().BeginTask(4),new FirstTaskAnswer(50.24,25.12));

    }
    @Test(expected = AssertionError.class)
    public void WrongInputBeginTask() {
        //S = 3.14 * r * r
        //L = 2 * 3.14 * r
        assertEquals(new Tasks().BeginTask(-3),new FirstTaskAnswer(3.14, 6.28));
        assertEquals(new Tasks().BeginTask(0),new FirstTaskAnswer(50.24,25.12));

    }
    @Test
    public void testIntegerTask()  {
        //First = value/10
        //Second = value%10
        assertEquals(new Tasks().IntegerTask(93),new SecondTaskAnswer(12,27));
        assertEquals(new Tasks().IntegerTask(11),new SecondTaskAnswer(2,1));

    }

    @Test(expected = AssertionError.class)
    public void WrongInputIntegerTask() {
        assertEquals(new Tasks().IntegerTask(12),new SecondTaskAnswer(1,2));
        assertEquals(new Tasks().IntegerTask(321),new SecondTaskAnswer(0,0));

    }

    @Test
    public void testBooleanTask() {
        //value1 < value2 < value3
        assertEquals(new Tasks().BooleanTask(1,2,3),true);
        assertEquals(new Tasks().BooleanTask(4,2,3),false);
        assertEquals(new Tasks().BooleanTask(1,2,-1),false);

    }

    @Test
    public void testIfTask() {
        //the ordinal number of the smaller number
        assertEquals(new Tasks().IfTask(1,2),1);
        assertEquals(new Tasks().IfTask(5,2),2);

    }

    @Test(expected = AssertionError.class)
    public void WrongInputIfTask(){
        assertEquals(new Tasks().IfTask(1,1),0);
    }
    @Test
    public void testSwitchTask() {
        //1 actual = weight * 1
        //2 actual = weight / 1 000 000
        //3 actual = weight  / 1 000
        //4 actual = weight * 1 000
        //5 actual = weight * 100
        assertEquals(new Tasks().SwitchTask(1,50),50,0.1);
        assertEquals(new Tasks().SwitchTask(2,1000),0.001,0.1);
        assertEquals(new Tasks().SwitchTask(3,500),0.5,0.01);
        assertEquals(new Tasks().SwitchTask(4,5),5000,0.1);
        assertEquals(new Tasks().SwitchTask(5,30),3000,0.1);
        assertEquals(new Tasks().SwitchTask(203,30),0,0.1);

    }

    @Test
    public void testForTask() {
        //sum of numbers from a to b
        assertEquals(new Tasks().ForTask(1,100),5050);
        assertEquals(new Tasks().ForTask(3,7),25);

    }

    @Test(expected = AssertionError.class)
    public void WrongInputForTask() {
        assertEquals(new Tasks().ForTask(0,0),9);
        assertEquals(new Tasks().ForTask(12,5),15);

    }

    @Test
    public void testWhileTask() {
        //Find the smallest k^2 > N
        assertEquals(new Tasks().WhileTask(10),4);
        assertEquals(new Tasks().WhileTask(8),3);

    }

    @Test(expected = AssertionError.class)
    public void WrongInputWhileTask() {
        assertEquals(new Tasks().WhileTask(-2),4);
        assertEquals(new Tasks().WhileTask(0),3);

    }

    @Test
    public void testArrayTask() {
        //find the difference of the arithmetic progression
        int array[] = {1,4,5,7,9};
        assertEquals(new Tasks().ArrayTask(new int[]{1,3,4}),0);
        assertEquals(new Tasks().ArrayTask(new int[]{3,5,7}),2);
        assertEquals(new Tasks().ArrayTask(new int[]{8,11,14,17}),3);

    }

    @Test
    public void testMatrixTask(){
        int[][] mas=new int[][] {
                {11,12,3,4},
                {15,16,7,8},
                {9,10,1,2},
                {13,14,3,4}};
        int[][] mas2=new int[][] {
                {4,12,3,11},
                {8,16,7,15},
                {2,10,1,9},
                {4,14,3,13}};
        Assert.assertTrue(Arrays.deepEquals(new Tasks().MatrixTask(mas,4,4),mas2));
        mas = new int[][]{{-11, -12, -3, -4},
                {-15, -16, -7, -8},
                {-9, -10, -1, -2},
                {-13, -14, -3, -4}};
        Assert.assertTrue(Arrays.deepEquals(new Tasks().MatrixTask(mas,4,4),mas));
    }

}