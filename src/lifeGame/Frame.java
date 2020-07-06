package lifeGame;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Frame {
    Frame() {
        JFrame jframe=new JFrame();
        jframe.setSize(771,800);
        JPanel jpanel=new JPanel();
        jpanel.setBounds(0,0,400,400);
        int count=0;
        Cell [][]cell=new Cell[30][30];
        cell= CellMap.initial();
        CellMap.getLiving(cell);
        jframe.setTitle("这是第"+count+"次演化");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setLocationRelativeTo(null);
        jframe.add(jpanel);
        jframe.setVisible(true);
        Graphics g=jpanel.getGraphics();
        for(int i=0;i<30;i++) {
            for(int j=0;j<30;j++) {
                g.drawRect(i*25, j*25, 25, 25);
            }
        }
        for(int i=0;i<30;i++) {
            for(int j=0;j<30;j++) {
                if(cell[i][j].getStatus()==1) {
                    g.fillRect(i*25, j*25, 25, 25);
                }
                else {
                    g.drawRect(i*25, j*25, 25, 25);
                }
            }
        }
        long d1= System.currentTimeMillis();
        while(true) {
            long d2= System.currentTimeMillis();
            if(d2-d1>2000) {
                int change;
                d1=d2;
                jframe.repaint();
                change= CellMap.update(cell);
                CellMap.getLiving(cell);
                for(int i=0;i<30;i++) {
                    for(int j=0;j<30;j++) {
                        g.drawRect(i*25, j*25, 25, 25);
                    }
                }
                for(int i=0;i<30;i++) {
                    for(int j=0;j<30;j++) {
                        if(cell[i][j].getStatus()==1) {
                            g.fillRect(i*25, j*25, 25, 25);
                        }
                        else {
                            g.drawRect(i*25, j*25, 25, 25);
                        }
                    }
                }
                count++;
                jframe.setTitle("这是第"+count+"次演化");
                if(change==30*30) break;
                if(count>1000) break;
            }
        }
        JOptionPane.showMessageDialog(jframe, "在第"+count+"次演化达到平衡", "提示", JOptionPane.PLAIN_MESSAGE);
    }
}


