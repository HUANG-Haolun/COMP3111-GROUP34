package ATU_Program;
import atu.input.*;
import atu.process.*;
import ATU_Program.Output.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

public class OutputTest{

    Student A;

    @Before
    public void setUp() throws Exception{
        A = new Student("202","jkl","12","1","qwer","k111","k2222");
        Output.createList(null, null, null);
    }

    @Test
    public void testgetmid(){
        assertEquals("202",A.getMid());
    }

    @Test
    public void testgetmname(){
        assertEquals("jkl",A.getMname());
    }

    @Test
    public void testgetteamnum(){
        assertEquals("12",A.getTeam_num());
    }

    @Test
    public void testmemid(){
        assertEquals("1",A.getMemid());
    }

    @Test
    public void testname(){
        assertEquals("qwer",A.getName());
    }

    @Test
    public void testk1(){
        assertEquals("k111",A.getK1());
    }

    @Test
    public void testk2(){
        assertEquals("k2222",A.getK2());
    }



//    @Test
//    public void chartting(){
//        assertEquals(1,Output.chart());
//    }

//   @Test
//   public void tableing(){
//       assertEquals(1,Output.table("qwer"));
//   }

}