package CH6;

abstract public class Radius {
	
	// the radius field
	private double radius;

	// constructor
	public Radius(double radius) {
		this.radius = radius;
	}	

	// the radius getter property
	public double getRadius() {
        return radius;
    }

	// the radius setter property
    public void setRadius(double radius) {
        this.radius = radius;
    }

	public abstract double getCircumference();

	public abstract double getArea();

}
