package webservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayFetch {
	public String getSailorInfoArray(String sailorInfo){
		ArrayList ip1=new ArrayList<String>(Arrays.asList("Y S","Anish","Catalina","23.5","2006","inboard","Yes","A1"));
		ArrayList ip2=new ArrayList<String>(Arrays.asList("Gaber","Sakr","Hunter","25","2006","outboard","No","B1"));
		ArrayList ip3=new ArrayList<String>(Arrays.asList("John","Ammanda","Morgan","50","2010","none","Yes","A19"));
		ArrayList ip4=new ArrayList<String>(Arrays.asList("kim","Kiesier","Catalina","40","2006","outboard","Yes","A41"));
		ArrayList ip5=new ArrayList<String>(Arrays.asList("Hee","Frank","Hunter","38.45","2012","outboard","No","B34"));
		ArrayList ip6=new ArrayList<String>(Arrays.asList("Yalmuri","Anish","Catalina","23.5","2006","inboard","Yes","A11"));
		ArrayList ip7=new ArrayList<String>(Arrays.asList("Hee","Lee","Hunter","38","2007","outboard","No","B35"));
		ArrayList ip8=new ArrayList<String>(Arrays.asList("Hee","Frank","Hunter","45","2009","outboard","No","B36"));
		ArrayList ip9=new ArrayList<String>(Arrays.asList("Hee","Frank","Catalina","36","2006","outboard","No","B37"));
		ArrayList ip10=new ArrayList<String>(Arrays.asList("chow","peng","Hunter","38","2006","inboard","Yes","B38"));
		/*String[] ip23={"anish","Y S"};
		String[] ip24={"anish","Y S"};
		String[][]={}*/
		ArrayList ipList=new ArrayList<ArrayList>(Arrays.asList(ip1,ip2,ip3,ip4,ip5,ip6,ip7,ip8,ip9,ip10));
		ArrayList tmpIpList =new ArrayList();
		tmpIpList=ipList;
		String[] sailorInfoArray=sailorInfo.split("%");
		for(int i=0;i<sailorInfoArray.length;i++){
			if(!sailorInfoArray[i].equals("")){
				tmpIpList=functionCalled(tmpIpList,sailorInfoArray[i]);
			}
		}
		
		Iterator it=tmpIpList.iterator();
		Iterator innerIt;
		String sailorDetails="";
		while(it.hasNext()){
			ArrayList tmp=(ArrayList<String>)it.next();
			innerIt=tmp.iterator();
			while(innerIt.hasNext()){
				sailorDetails+=(String)innerIt.next();
				sailorDetails+="-";
			}
			sailorDetails+="&";
		}
		
		return sailorDetails;
	}
	
	
	 public static ArrayList functionCalled(ArrayList ipList,String matchingValue){
	    	ArrayList opList=new ArrayList<ArrayList>();
	    	Iterator it=ipList.iterator();
			while(it.hasNext()){
				ArrayList tmp=(ArrayList<String>)it.next();
				
				if(tmp.contains(matchingValue)){
					opList.add(tmp);
				}
				
				//System.out.println(tmp.contains("kim"));
			}
			return opList;
			
		}

}
