class Pattern{
	public static void main(String[] args){
		int row = 5;
		int star = 1;
		int space = row-1;
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < space; k++) {
				System.out.print(" ");

			}
			for (int j = 0; j < star; j++) {
				System.out.print("*");
			}
			System.out.println();
			star++; //5
			space--; //0
		}
		
		//Reverse the pattern
		for(int i=0; i<row; i++){
			for(int k=0; k<space; k++){
				System.out.print(" ");
			}
			for(int j=0; j<star; j++){
				System.out.print("*");
			}
			System.out.println();
			star--;
			space++;
		}		
	}
}