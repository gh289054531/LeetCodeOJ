package Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> result=new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        if(n<1 || k<=0){
            result.add(new ArrayList<Integer>());
            return result;
        }
        for(int i=1;i<=n;i++){
            List<Integer> cur=new ArrayList<Integer>();
            cur.add(i);
            chooseMore(n,k,cur,i+1);
            cur.remove(0);
        }
        return result;
    }
    
    private void chooseMore(int n,int k, List<Integer> cur,int index){
        if(cur.size()==k){
            result.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i=index;i<=n;i++){
            cur.add(i);
            chooseMore(n,k,cur,i+1);
            cur.remove(cur.size()-1);
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
