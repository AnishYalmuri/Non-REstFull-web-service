package webservices;

public class HelloProxy  {
  private String _endpoint = null;
  private webservices.Hello hello = null;
  
  public HelloProxy() {
    _initHelloProxy();
  }
  
  public HelloProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloProxy();
  }
  
  private void _initHelloProxy() {
    try {
      hello = (webservices.Hello) (new webservices.HelloServiceLocator()).getHelloPort();
      if (hello != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hello)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hello != null)
      ((javax.xml.rpc.Stub)hello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public webservices.Hello getHello() {
    if (hello == null)
      _initHelloProxy();
    return hello;
  }
  
  public void Hello(){
    if (hello == null)
      _initHelloProxy();
    hello.Hello();
  }
  
  public java.lang.String findSailorInfo(java.lang.String name){
    if (hello == null)
      _initHelloProxy();
    return hello.findSailorInfo(name);
  }
  
  
}