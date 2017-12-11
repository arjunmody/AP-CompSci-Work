import java.awt.geom.*;
/**
 * Write a description of class IrregularPolygonDriver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver
{
   public static void main(String[] args) 
    {
        IrregularPolygon points = new IrregularPolygon();
        points.add(new Point2D.Double(0,0));
        points.add(new Point2D.Double(0,200));
        points.add(new Point2D.Double(100,300));
        points.add(new Point2D.Double(200,200));
        points.add(new Point2D.Double(200,0));
        points.draw();
        System.out.println("The Perimeter is: " + points.perimeter());
        System.out.println("The Area is: " + points.area());
    }
}
