package com.xmu.swordoffer;

import java.util.Stack;

public class PushPopSeqInStack {
	
	public static void main(String[] args) {
		System.out.println(IsPopOrder(new int[] {1,2,3,4,5},
				new int[] {4,3,5,1,2}));
	}
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
	      if(pushA.length!=popA.length)
	    	  return false;
	      Stack<Integer> stack = new Stack();
	      int len = popA.length;
	      int pushInd = 0;
	      int popInd=0;
	      while(popInd<len) {
	    	   if(!stack.isEmpty() &&
	    			   stack.peek()==popA[popInd])
	    		   stack.pop();
	    	   else {
	    		   while(pushInd<len && pushA[pushInd]!=popA[popInd]) {
	    			   stack.push(pushA[pushInd]);
	    			   pushInd++;
	    		   }
	    		   if(pushInd>=len)
	    			   return false;
	    		   pushInd++;
	    	   }
	    	   popInd++;
	      }
	      return true;
    }
}
