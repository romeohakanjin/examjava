package webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.12
 * 2018-07-02T14:47:27.666+02:00
 * Generated source version: 3.1.12
 * 
 */
@WebServiceClient(name = "WebServiceSessionBeanService", 
                  wsdlLocation = "http://Junzi:8080/exam-java-ws/WebServiceSessionBean?wsdl",
                  targetNamespace = "http://webservice/") 
public class WebServiceSessionBeanService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webservice/", "WebServiceSessionBeanService");
    public final static QName WebServiceSessionBeanPort = new QName("http://webservice/", "WebServiceSessionBeanPort");
    static {
        URL url = null;
        try {
            url = new URL("http://Junzi:8080/exam-java-ws/WebServiceSessionBean?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WebServiceSessionBeanService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://Junzi:8080/exam-java-ws/WebServiceSessionBean?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WebServiceSessionBeanService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WebServiceSessionBeanService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServiceSessionBeanService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public WebServiceSessionBeanService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public WebServiceSessionBeanService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public WebServiceSessionBeanService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns WebServiceSessionBean
     */
    @WebEndpoint(name = "WebServiceSessionBeanPort")
    public WebServiceSessionBean getWebServiceSessionBeanPort() {
        return super.getPort(WebServiceSessionBeanPort, WebServiceSessionBean.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServiceSessionBean
     */
    @WebEndpoint(name = "WebServiceSessionBeanPort")
    public WebServiceSessionBean getWebServiceSessionBeanPort(WebServiceFeature... features) {
        return super.getPort(WebServiceSessionBeanPort, WebServiceSessionBean.class, features);
    }

}