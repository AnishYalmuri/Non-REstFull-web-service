package webServiceClient;

import java.rmi.RemoteException;
import java.util.HashMap;

import javax.xml.rpc.ServiceException;

import webservices.HelloPortBindingStub;
import webservices.HelloServiceLocator;

public class sailorClient {
	public static void main(String[] args) {
    	webservices.HelloPortBindingStub port=null;
    	HelloServiceLocator hsc= new HelloServiceLocator();
    	try {
			port = (HelloPortBindingStub) hsc.getHelloPort();
			HashMap test=new HashMap();
			test.put("first_name", "Anish");
			test.put("last_name", "Yalmuri");
			test.put("boat_type", "Sonata");
			//test.put("first_name", "Anish");
			System.out.println(port.findSailorInfo("test"));
			
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
