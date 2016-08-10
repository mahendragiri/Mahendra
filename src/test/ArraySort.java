
//helper branch

package test;
import java.util.Arrays;
public class ArraySort {
	public static String[] sort(String[] str){
		for(int i=0;i<str.length;i++){
			for(int x=i+1;x<str.length;x++){
				
				int p=str[i].length()<str[x].length()?str[i].length():str[x].length();
				for(int a=0;a<p;a++){
					
					if(str[i].toLowerCase().charAt(a)>str[x].toLowerCase().charAt(a)){
						String temp=str[i];
						str[i]=str[x];
						str[x]=temp;
						break;
					}else if(str[i].charAt(a)<str[x].charAt(a)){
						break;
					}
				}
			}
		}
		System.out.println(Arrays.toString(str));
		System.out.println("helper branch");
		return str;
	}	
	public static void main(String[] args) {
		String[] str={"shashank","manoj","ravi","aman","baby","kk","Aman","aradhna","sunny","aaa","shshnk"};
		sort(str);
	}

}
