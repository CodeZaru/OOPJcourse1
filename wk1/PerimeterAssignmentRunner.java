import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        //basically creates like a starting point
        //for the distance method to reference as its implicit 'this' 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        //this method returns an integer that is the number of points in Shape
        //declare count variable and use naming descriptive convention
        int pointCountOfShape = 0;
        //using the getPoints method of the shape class loop through the shape object's points
        for(Point p : s.getPoints()){
        //increment pointCount each iteration
            pointCountOfShape += 1;
        }
        return pointCountOfShape;
    }

    public double getAverageLength(Shape s) {
        // this method returns a number of type double that is the calculated
        //avg of all sides' lengths in Shape S
        //use the 7 step approach and solve the algorithm on paper then convert to code
        //double perimeter = getPerimeter(s);
        //int numberOfSides = getNumPoints(s);
        //double averageLength = perimeter/numberOfSides;
        //refactor the above three steps into one line
        double averageLength = getPerimeter(s)/getNumPoints(s);
        
        return averageLength;
    }

    public double getLargestSide(Shape s) {
        // define variables
        // prevPoint is like the starting point for the loop
        //then once in the loop we take the variable 'prevPoint' and 
        //keep resetting its value as we iterate thu the loop
        Point prevPoint = s.getLastPoint();
        double longestSide = 0.0;
        
        for(Point p : s.getPoints()){
            double currentSide = prevPoint.distance(p);
            if(currentSide > longestSide) {
                longestSide = currentSide;
            }
            prevPoint = p;
        }
              
        return longestSide;
    }

    public double getLargestX(Shape s) {
        // notes..
        double largestX = 0.0;
        
        for(Point p : s.getPoints()){
            int coordinateX = p.getX();
            if(coordinateX > largestX) {
                largestX = (double) coordinateX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // notes
        DirectoryResource dr = new DirectoryResource();
        double largestPerimeterMultipleFiles = 0.0;
        
        for(File f : dr.selectedFiles()){
            //similar to testPerimeter method, except in a for loop so pass in
            //the individual files from selected array of files
            FileResource fr = new FileResource(f);
            //pass the fr instance as arg to Shape constructor
            //assume that it has the necessary args to 
            //satisfy Shape constructors method signature
            Shape s = new Shape(fr);
            double length = getPerimeter(s);
            if(length > largestPerimeterMultipleFiles) {
                largestPerimeterMultipleFiles = length;
            }
        }
            
        return largestPerimeterMultipleFiles;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        //pass the fr instance as arg to Shape constructor
        //assume that it has the necessary args to satisfy Shape constructors method signature
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        //add code to call getNumPoints and to print the result
        int pointCountOfShape = getNumPoints(s);
        //add code to call getAverageLength and to print the result
        double averageLengthOfSides = getAverageLength(s);
        //add code to call getLargestSide and to print the result
        double longestSide = getLargestSide(s);
        //add code to call getLargestX and to print the result
        double largestX = getLargestX(s);
        
        System.out.println("perimeter = " + length);
        System.out.println("Number of Points in Shape: " + pointCountOfShape);
        System.out.println("Average Length of Sides: " + averageLengthOfSides);
        System.out.println("longest Side: " + longestSide);
        System.out.println("largestX: " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
