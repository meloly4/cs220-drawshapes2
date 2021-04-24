package knox.drawshapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends AbstractShape{

	private int length;

	public Triangle(Color color, Point center, int length) {
		super(center, color);
    boundingBox = new BoundingBox(center.x + length/2, center.x - length/2, center.y + length/2, center.y - length/2);
    this.length=length;
	}

	@Override
	public void draw(Graphics g) {
		if(isSelected()) {
			g.setColor(getColor().darker());
		} else {
			g.setColor(getColor());
    }
    int x = (int)getAnchorPoint().x;
    int y = (int)getAnchorPoint().y;
		int[] xPoint = new int[] {x - length/2, x, x + length/2};
		int[] yPoint = new int[] {y + length/2, y - length/2, y + length/2};
		g.fillPolygon(xPoint,yPoint,3);
	}

	public String toString() {
		return String.format("TRIANGLE %d %d %d %s %s",
				getAnchorPoint().x,
				getAnchorPoint().y,
				length,
				Util.colorToString(getColor()),
				selected);
	}

	@Override
	public void scale(double factor) {
		this.length=(int)(this.length * factor);
	}

}
