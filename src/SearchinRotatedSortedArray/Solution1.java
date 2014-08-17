package SearchinRotatedSortedArray;

public class Solution1 {
    public int search(int[] A, int target) {
        if(A==null||A.length==0){
            return -1;
        }
        int left=0,right=A.length-1;
        while(left<=right){
            if(left==right){
                return target==A[left]?left:-1;
            }
            if(left+1==right){
                if(target==A[left]){
                    return left;
                }else if(target==A[right]){
                    return right;
                }else{
                    return -1;
                }
            }
            int mid=(left+right)>>1;
            if(target==A[mid]){
                return mid;
            }
            if(A[mid]<A[left]&&A[mid]<A[right]){
                if(A[mid]<target){
                    if(A[right]>=target){
                        left=mid+1;
                    }else{
                        right=mid-1;
                    }
                }else{
                    right=mid-1;
                }
            }else if(A[mid]>A[left] && A[mid]>A[right]){
                if(A[mid]<target){
                    left=mid+1;
                }else{
                    if(target>=A[left]){
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }
            }else if(A[mid]>A[left]&&A[mid]<A[right]){
                if(A[mid]<target){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
		int[] input=new int[]{5,1,3};
		System.out.println(new Solution1().search(input, 5));
	}
}