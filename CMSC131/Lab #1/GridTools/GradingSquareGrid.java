package GridTools;

import java.awt.Color;

public class GradingSquareGrid extends SquareGrid {

	private static final long serialVersionUID = 0L;
	
	//protected int scaleH;
	//protected int scaleW;
	//protected Color[][] colors;
	
	protected GradingSquareGrid() {
	}
	
	public GradingSquareGrid(int scale) {
		this.scaleH = scale;
		this.scaleW = scale;
		
		colors = new Color[scale][scale];
		for (int i = 0; i < scale; i++)
			for (int j = 0; j < scale; j++)
				colors[i][j] = Color.WHITE;
		
	}
	
	public int getScale(){
		return scaleH;
	}
	
	public int getHt() {
		return scaleH;
	}
	
	public int getWd(){
		return scaleW;
	}
	
	public boolean equals(Object x) {
		if ( x == null || getClass() != x.getClass())
			return false;
		GradingSquareGrid xx = (GradingSquareGrid)x;
		for (int i = 0; i < scaleH; i++) {
			for (int j = 0; j < scaleH; j++) {
				if (xx.colors[i][j] != colors[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void setColor(int row, int col, Color color) {
		colors[row][col] = color;
	}
}
