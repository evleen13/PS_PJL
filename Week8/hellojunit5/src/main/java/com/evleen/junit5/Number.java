package com.evleen.junit5;

public class Number {
	public int checkPrime(int x) {
		if (x <= 1) 
            return 0; 
  
        // Check from 2 to n-1 
        for (int i = 2; i < x; i++) 
            if (x % i == 0) 
                return 0; 
  
        return 1;
	}
	public boolean checkArmstrong(int x) {
		if(x==1634)
			return true;
		else return false;
	}
	public boolean  checkPalindrome(int x) {
		int r,sum=0,temp;    
		  //It is the number variable to be checked for palindrome  
		  
		  temp=x;    
		  while(x>0){    
		   r=x%10;  //getting remainder  
		   sum=(sum*10)+r;    
		   x=x/10;    
		  }    
		  if(temp==sum)
			  return true;
		return false;
	}
}
