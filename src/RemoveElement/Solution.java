package RemoveElement;


public class Solution {

	public int removeElement(int[] A, int elem) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
		if(A==null){
			return -1;
		}
		int length=A.length;
		for(int i=0;i<length;){
			if(A[i]==elem){
				A[i]=A[--length];
			}else{
				i++;
			}
		}
		return length;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
