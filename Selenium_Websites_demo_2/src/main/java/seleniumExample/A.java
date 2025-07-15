package seleniumExample;

import java.util.HashMap;

public class A {

	public static void main(String[] args) {

		      String s ="aaabbc";
		    char[] a = s.toCharArray();
		    HashMap<Character,Integer> newobj = new HashMap<Character,Integer>();
		    int count = 1;
		    for(int i=0; i<a.length; i++)
		    {
		        if(!newobj.containsKey(a[i]))
		        {
		            newobj.put(a[i], count);
		        }else
		        {
		            newobj.put(a[i], newobj.get(a[i])+1);
		        }
		    }
		    for(Character j: newobj.keySet())
		    {
		        System.out.print(j + "" + newobj.get(j));
		    }
		  }
		

	}


