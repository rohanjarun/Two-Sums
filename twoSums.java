import java.util.Scanner;

public class twoSums{


	public twoSums(){};

	public int [] twoSums(int [] num, int sum){
		//first copies the given list
		int [] origArray=arrayDuplicate(num);
		//sorts the inputted list from smallest to biggest value
		int [] sortedArray=sort(num);
		int first=0,last=num.length-1;
		boolean found=false;
		while(!found){
			//not allowed to have the same number twice
			if(first==last)
			{
				break;
			}
			//change the value of the index to the smallest value
			else if(sortedArray[first]+sortedArray[last]>sum)
			{
				last--;
			}
			//change value of the index to the largest value
			else if(sortedArray[first]+sortedArray[last]<sum)
			{
				first++;
			}
			else
				found=true;
			//The summation is found if all the checks are valid
		}

		if(found){//New (sorted) list has different positions from the main list
			for(int j=0;j<num.length;j++){
			//checks for the original position
				
				if(sortedArray[first]==origArray[j])
					first=j;
	
				if(sortedArray[last]==origArray[j])
					last=j;
			}
			return new int []{first,last};
		}
		else
			//only when num is found twice
			return new int []{-1,-1};
	}
	//Checks and sorts from small to big number
	public int [] sort(int [] num){
		int smallest=num[0];
		for(int j =0;j<num.length;j++){
			if(num[1]<smallest){
				num[0]=num[1];
				num[1]=smallest;
				smallest=num[0];
			}
		}
		return num;
	}
	
	//makes a copy of list to compare the sorted and unsorted list
	public int [] arrayDuplicate(int [] num)
	{
		int [] duplicate=new int [num.length];
		for(int j=0;j<num.length;j++)
		{
			duplicate[j]=num[j];
		}
		return duplicate;
	}
	
	//main function which calls twosums and asks for input
	public static void main(String [] args){
		twoSums t=new twoSums();
		Scanner scanner=new Scanner(System.in);
		//prompts user to give length of the list
		System.out.println("How many values (length) in the list?");
		int length=scanner.nextInt();
		int [] num=new int[length];
		//prompts user to input the variables in the list
		System.out.println("Please input all the values");
		int j=0;
		while(j<length){
			num[j]=scanner.nextInt();
			j++;
		}
		System.out.println("Target?");
		int val=scanner.nextInt();
		int [] index=t.twoSums(num,val);
		System.out.println("Position- "+ "nums"+index[0]+" + "+"nums"+index[1]);

	}
}