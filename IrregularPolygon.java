import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import java.util.Iterator;
import gpdraw.*;            // for DrawingTool

public class IrregularPolygon 
{
    private ArrayList <Point2D.Double> Polygon = new ArrayList<Point2D.Double>();
    private ArrayList<Double> perim = new ArrayList<Double>();
    private DrawingTool Pencil;
    private SketchPad Paper;
    private String name;
    //constructors
    public IrregularPolygon()
    {
        Paper = new SketchPad(500, 500);
        Pencil = new DrawingTool(Paper);
        ArrayList <Point2D.Double> Polygon;
    }
    // public methods
    public void add(Point2D.Double aPoint)  
    {
        Polygon.add(aPoint);
    }
    public String getName()
    {
        this.name = "Arjun Mody";
        return name;
    }
        
    public void draw() 
    {
        Pencil.up();
        Point2D.Double first = Polygon.get(0);
        Pencil.move(first.x, first.y);
        Pencil.down();
        Iterator<Point2D.Double> iterate = Polygon.iterator();
        while(iterate.hasNext())
        {
             Point2D.Double next = iterate.next();
             Pencil.move(next.x, next.y);
        }
        Pencil.move(first.x, first.y);
    }
    public double perimeter() 
    {
        for (int i = 0; i < Polygon.size()-1; i++) 
        {
            double dist = 0;
            Point2D.Double point1 = Polygon.get(i);
            Point2D.Double point2 = Polygon.get(i+1);
            dist = Math.pow(Math.pow(point2.x - point1.x, 2.0) + Math.pow(point2.y - point1.y, 2.0), 0.5);
            perim.add(dist);
        }
        Point2D.Double c = Polygon.get(Polygon.size()-1);
        Point2D.Double b = Polygon.get(0);
        perim.add(Math.pow(Math.pow(c.x - b.x, 2.0) + Math.pow(c.y - b.y, 2.0), 0.5));
        Iterator<Double> sides = perim.iterator();
        double perimeter = 0.0;
        while(sides.hasNext())
        {
            double nextOne = sides.next();
            perimeter = nextOne + perimeter;
        }
        return perimeter;
    }
    public double area() 
    {
        double area = 0.0;
        Point2D.Double lastPoint = Polygon.get(Polygon.size()-1);
        Point2D.Double firstPoint = Polygon.get(0);
        for(int i = 0; i < Polygon.size()-1; i++) 
        {
            Point2D.Double point1 = Polygon.get(i);
            Point2D.Double point2 = Polygon.get(i+1);
            area += (point1.x * point2.y) - (point1.y * point2.x);
        }
        area += (lastPoint.x * firstPoint.y) - (lastPoint.y * firstPoint.x);
        return Math.abs(area/2.0);
    }
}