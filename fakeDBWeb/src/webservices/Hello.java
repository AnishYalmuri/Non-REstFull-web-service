package webservices;

import java.util.HashMap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Hello {
	//private String message = new String("Hello,Bosudi ");

    public void Hello() {
    }

    @WebMethod
    public String findSailorInfo(String sailorDetail) {
    	/*DatabaseFetch dbf=new DatabaseFetch();
    	String details=dbf.findSailorRecordInDB(name);*/
    	ArrayFetch af= new ArrayFetch();
    	String details=af.getSailorInfoArray(sailorDetail);
        return  details ;
    }
    /*@WebMethod
    public String findSailorInfo(HashMap sailorDetails) {
    	String op=(String)(sailorDetails.get("first_name")+" "+
    			(String)sailorDetails.get("last_name")+" "+
    	(String)sailorDetails.get("boat_type"));
        return message + op + ".";
    }*/
    
    
    
}
