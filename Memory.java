package project5;
	import java.util.*;
	import java.io.*;
	import java.text.DecimalFormat;
	import java.math.RoundingMode;
	import java.io.FileNotFoundException;

import org.json.JSONException;
import org.json.JSONObject;
	public class Memory {

		public static void main(String[] args) throws IOException, JSONException 
		{
			double[] array = new double[10000];
			JSONObject obj  = new JSONObject();
			JSONObject obj1 = new JSONObject();
			File file = new File("C:\\Users\\Windows\\Desktop\\Memory.txt");
			try (BufferedReader bf = new BufferedReader(new FileReader(file))) 
	        {
	            String string;
	            double temp;
	            int line = 0;
	            int i=0;
	            double sum=0.0;
	            double max = 0.0;
	            while ((string = bf.readLine()) != null) 
	            {
	                if (line % 2 != 0) {
	                	String str=string;
	                	str=str.replaceAll("[^0-9]","");
	                    str=str.trim();
	                    temp=Integer.parseInt(str);
	                    array[i++]=temp/10000;
	                }
	                line++;
	            }
	            String string1;
	            for(int j=0;j<938;j++)
	            {
	            	string1 = String.format("%d",j);
	            	obj1.put(string1 + "s", array[j]);
	            	if(max<array[j])
	            		max=array[j];
	            	sum=sum+array[j];
	            }
	            double avg=sum/938;
	            DecimalFormat df = new DecimalFormat("#.###");
	            df.setRoundingMode(RoundingMode.CEILING);
	            obj.put("AverageMemory(MB)", df.format(avg));
	            obj.put("values: ", obj1);
	            obj.put("MaximumMemory(MB)", df.format(max));
	            System.out.println(obj);
	         }
	 }
	
}
