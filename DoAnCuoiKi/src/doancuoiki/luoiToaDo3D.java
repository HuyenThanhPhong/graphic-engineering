/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doancuoiki;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Mylov
 */
public class luoiToaDo3D  extends JPanel implements ActionListener{
    private List <Pixel> pixel= new LinkedList<Pixel>(); // test mouse Click
     Timer tm= new Timer(100, this); // Timer(a,b); a la thoi gian delay;

    
     
     public void addPixel(Pixel p){
         pixel.add(p);
         this.repaint();
     }
     public void paintComponent(Graphics g){
         doDraw((Graphics2D) g);
         super.getComponents();
         super.paintComponent(g);
         doDraw((Graphics2D) g);
         for(Pixel p:pixel){
             p.draw(g,Color.green);
         }
        tm.start();
     }
     public  void demo(Graphics g){

         DuongTron3D abc= new DuongTron3D(new Point3D(30,0, 20), 10);
         abc.bresenhamCircle(g, Color.yellow);
        Point3D pf= new Point3D(30,20 ,20 );
        pf.tranFormToPixel().draw(g, Color.red);

         
//         int x = Integer.parseInt(MainFrame.HX.getText());
//         int y = Integer.parseInt(MainFrame.HY.getText());
//         int z = Integer.parseInt(MainFrame.HZ.getText());
//         int d = Integer.parseInt(MainFrame.dai.getText());
//         int r = Integer.parseInt(MainFrame.rong.getText());
//         int h = Integer.parseInt(MainFrame.cao.getText());
//        
//         new HinhHop(new Point3D(x, y, z), r, d, h).draw(g, Color.gray);
         
        //Integer.parseInt(MainFrame.textField.getText());
        
       // Point3D P = new Point3D(10, 0, 0);
       // P.tranFormToPixel().draw(g, Color.green);
       // Point3D PP = new Point3D(50, 0, 50);
        //Point3D Tam = new Point3D(100, 0, 10);
        //PP.tranFormToPixel().draw(g, Color.green);
        //new Eclip(PP.tranFormToPixel(), 20, 10).draweEllipseMidPoint(g, Color.yellow, false);
     // new HinhTru(PP, 25, 40).drawHinhTru(g, Color.green);
      // new HinhCau(Tam, 30).drawHinhCau(g, Color.yellow);
       //new CircleLineBreak(PP.tranFormToPixel(), 25).bresenhamCircleBreak(g, Color.yellow);
       //new RectangleFull(P.tranFormToPixel(), 20, 10).DrawRectFull(g, Color.gray);
      // new CircleFull(PP.tranFormToPixel(), 10).CircleFull(g, Color.gray);
       // HinhHop HH = new HinhHop(P, PP, 50);
       // HH.draw(g, Color.gray);
         

     }
     public void doDraw(Graphics2D g){
       // this.keLine(g);
       this.veTrucToaToa(g);
//       MainFrame.VeHinhHop.addActionListener(new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent e) {
//              MainFrame.jFrame.repaint();
//                demo(g);
//                
//              // MainFrame.jFrame.add(MainFrame.VeHinhHop);
//           }
//       } );
        
        //demo(g);
    }
    private void keLine(Graphics2D g){
        Graphics2D g2d=(Graphics2D) g;
        //line doc
        g2d.setPaint(Color.BLACK);
        int maxWight=1228;
        int maxHight=800;
        int begin=5;
        while(begin<1200){
            g2d.drawLine(begin, 5, begin, 795);
            begin=begin+5;
        }
        begin=5;
        while(begin<800){
            g2d.drawLine(5, begin, 1195, begin);
            begin=begin+5;
        }
    }
    private void veTrucToaToa(Graphics2D g){
        Graphics2D g2d=(Graphics2D) g;
        g2d.setPaint(Color.RED);
        g2d.drawString("Ox", 1180, 415); //ki hieu ox
        g2d.drawLine(600, 400, 1200, 400); // khung la 1200x800 // ve truc ox
        g2d.drawLine(600, 401, 1200, 401); // do lai truc ox
        g2d.drawLine(601, 2, 601,400); // ve truc oy
        g2d.drawString(">", 1195, 405);
        g2d.drawString("^", 598, 12);
        g2d.drawString("Oy", 580, 20);
        g2d.drawString("O", 590, 412);
        Point3D p1= new Point3D(0, 0, 0);
        Point3D p2= new Point3D(0, 0, 400);
        Pixel pixel1= new ChuyenToaDo(p1.tranFormToPixel().getX(), p1.tranFormToPixel().getY()).NguoiDung_to_May();
        Pixel pixel2= new ChuyenToaDo(p2.tranFormToPixel().getX(), p2.tranFormToPixel().getY()).NguoiDung_to_May();
        g2d.drawLine(pixel1.getX(),pixel1.getY(),pixel2.getX(),pixel2.getY());
        g2d.drawLine(pixel1.getX()+1,pixel1.getY(),pixel2.getX()+1,pixel2.getY());
        g2d.drawString("OZ", 190, 790);
        g2d.setPaint(Color.BLACK);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
