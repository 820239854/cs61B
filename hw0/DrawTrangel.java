public class DrawTrangel{
	public static void drawTriangle(){
		int x = 5;
		while(x>0){
			int y = 6-x;
			while(y>0){
				System.out.print("*");
				y -= 1;
			}
			System.out.println();
			x -= 1;
		}		
	} 

	public static void main(String[] args) {
		drawTriangle();
	}
}