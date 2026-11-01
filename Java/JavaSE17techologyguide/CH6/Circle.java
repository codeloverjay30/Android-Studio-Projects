package CH6;

import java.util.*;

public class Circle extends Radius{

	public Circle(double radius){
		super(radius);
	}

    // The circumference property
    public double getCircumference() {
        return 2 * Math.PI * this.getRadius();
    }

	// The circumference property
    public double getArea() {
        return Math.PI * Math.PI * this.getRadius();
    }

}