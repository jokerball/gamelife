package lifeGame;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class CellMapTest {
    private static CellMap map=new CellMap();
    private static Cell [][]cell=new Cell[30][30];
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        cell=map.initial();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        ;
    }

    @Test
    public void testGetLiving() {
        for(int i=0;i<30;i++) {
            for(int j=0;j<30;j++) {
                cell[i][j].setStatus(1);
            }
        }
        map.getLiving(cell);
        for(int i=0;i<30;i++) {
            for(int j=0;j<30;j++) {
                if(i>0&&i<29&&j>0&&j<29) assertEquals(8,cell[i][j].getLiving());
                else if((i==0||i==29)&&(j>0&&j<29)||(j==0||j==29)&&(i>0&&i<29)) assertEquals(5,cell[i][j].getLiving());
                else assertEquals(3,cell[i][j].getLiving());
            }
        }
        for(int i=0;i<30;i++) {
            for(int j=0;j<30;j++) {
                cell[i][j].setStatus(0);
            }
        }
        map.getLiving(cell);
        for(int i=0;i<30;i++) {
            for(int j=0;j<30;j++) {
                assertEquals(0,cell[i][j].getLiving());
            }
        }
    }

    @Test
    public void testUpdate() {
        for(int i=0;i<30;i++) {
            for(int j=0;j<30;j++) {
                cell[i][j].setStatus(1);
            }
        }
        map.getLiving(cell);
        assertEquals(4,map.update(cell));
        for(int i=0;i<30;i++) {
            for(int j=0;j<30;j++) {
                cell[i][j].setStatus(0);
            }
        }
        map.getLiving(cell);
        assertEquals(900,map.update(cell));
    }

}