package Org.Testing.TestTrigger;

import Org.Testing.TestCases.TC_1_Get;
import Org.Testing.TestCases.TC_2_Post;
import Org.Testing.TestCases.TC_3_Delete;
import Org.Testing.TestCases.TC_4_Put;
import org.testng.annotations.Test;

import java.io.IOException;

public class Trigger1 {
    @Test(priority = 1)
    public void second() throws IOException {
        System.out.println("Called TestCase 2-Post() Request");
        TC_2_Post TC2Obj=new TC_2_Post();
        TC2Obj.TestCase2();
        System.out.println("---------End of Test Case 2 the Post Request-----");
        System.out.println("\n");

    }
    @Test(priority = 2)
    public void first() throws IOException {
        System.out.println("Called Test Case 1- get() Request");
        TC_1_Get TC1Obj= new TC_1_Get();
        TC1Obj.testcase1();
        System.out.println("----------End of Test case 1 the Get Request-----------");
        System.out.println("\n");

    }
    @Test(priority = 3)
    public void fourth() throws IOException {
        System.out.println("Called Test Case 4-Put request");
        TC_4_Put TC4Obj= new TC_4_Put();
        TC4Obj.testcase4();
        System.out.println("--------End of TestCase 4 put() Request-------");
        System.out.println("\n");
    }
    @Test(priority = 4)
    public void third() throws IOException {
        System.out.println("Called Test Case 3- Delete() Request");
        TC_3_Delete TC3Obj=new TC_3_Delete();
        TC3Obj.TestCase3();
        System.out.println("----------End of Test Case 3 Delete() Request-----");

    }
}
