package Paint;

public abstract class Color {
	String color;
	Color()
	{
		
	}
	abstract void drawLine(int a, int b, int c, int d);
	abstract void drawCircle(int a, int b, int c);
}
