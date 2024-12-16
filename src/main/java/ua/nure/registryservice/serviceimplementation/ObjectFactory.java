
package ua.nure.registryservice.serviceimplementation;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ua.nure.registryservice.serviceimplementation package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Registry_QNAME = new QName("http://ServiceImplementation.RegistryService.nure.ua/", "Registry");
    private final static QName _DeleteService_QNAME = new QName("http://ServiceImplementation.RegistryService.nure.ua/", "deleteService");
    private final static QName _DeleteServiceResponse_QNAME = new QName("http://ServiceImplementation.RegistryService.nure.ua/", "deleteServiceResponse");
    private final static QName _GetAllServices_QNAME = new QName("http://ServiceImplementation.RegistryService.nure.ua/", "getAllServices");
    private final static QName _GetAllServicesResponse_QNAME = new QName("http://ServiceImplementation.RegistryService.nure.ua/", "getAllServicesResponse");
    private final static QName _GetServiceByName_QNAME = new QName("http://ServiceImplementation.RegistryService.nure.ua/", "getServiceByName");
    private final static QName _GetServiceByNameResponse_QNAME = new QName("http://ServiceImplementation.RegistryService.nure.ua/", "getServiceByNameResponse");
    private final static QName _RegisterService_QNAME = new QName("http://ServiceImplementation.RegistryService.nure.ua/", "registerService");
    private final static QName _RegisterServiceResponse_QNAME = new QName("http://ServiceImplementation.RegistryService.nure.ua/", "registerServiceResponse");
    private final static QName _UpdateServiceStatus_QNAME = new QName("http://ServiceImplementation.RegistryService.nure.ua/", "updateServiceStatus");
    private final static QName _UpdateServiceStatusResponse_QNAME = new QName("http://ServiceImplementation.RegistryService.nure.ua/", "updateServiceStatusResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ua.nure.registryservice.serviceimplementation
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Registry }
     * 
     */
    public Registry createRegistry() {
        return new Registry();
    }

    /**
     * Create an instance of {@link DeleteService }
     * 
     */
    public DeleteService createDeleteService() {
        return new DeleteService();
    }

    /**
     * Create an instance of {@link DeleteServiceResponse }
     * 
     */
    public DeleteServiceResponse createDeleteServiceResponse() {
        return new DeleteServiceResponse();
    }

    /**
     * Create an instance of {@link GetAllServices }
     * 
     */
    public GetAllServices createGetAllServices() {
        return new GetAllServices();
    }

    /**
     * Create an instance of {@link GetAllServicesResponse }
     * 
     */
    public GetAllServicesResponse createGetAllServicesResponse() {
        return new GetAllServicesResponse();
    }

    /**
     * Create an instance of {@link GetServiceByName }
     * 
     */
    public GetServiceByName createGetServiceByName() {
        return new GetServiceByName();
    }

    /**
     * Create an instance of {@link GetServiceByNameResponse }
     * 
     */
    public GetServiceByNameResponse createGetServiceByNameResponse() {
        return new GetServiceByNameResponse();
    }

    /**
     * Create an instance of {@link RegisterService }
     * 
     */
    public RegisterService createRegisterService() {
        return new RegisterService();
    }

    /**
     * Create an instance of {@link RegisterServiceResponse }
     * 
     */
    public RegisterServiceResponse createRegisterServiceResponse() {
        return new RegisterServiceResponse();
    }

    /**
     * Create an instance of {@link UpdateServiceStatus }
     * 
     */
    public UpdateServiceStatus createUpdateServiceStatus() {
        return new UpdateServiceStatus();
    }

    /**
     * Create an instance of {@link UpdateServiceStatusResponse }
     * 
     */
    public UpdateServiceStatusResponse createUpdateServiceStatusResponse() {
        return new UpdateServiceStatusResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Registry }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Registry }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServiceImplementation.RegistryService.nure.ua/", name = "Registry")
    public JAXBElement<Registry> createRegistry(Registry value) {
        return new JAXBElement<Registry>(_Registry_QNAME, Registry.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteService }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteService }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServiceImplementation.RegistryService.nure.ua/", name = "deleteService")
    public JAXBElement<DeleteService> createDeleteService(DeleteService value) {
        return new JAXBElement<DeleteService>(_DeleteService_QNAME, DeleteService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteServiceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteServiceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServiceImplementation.RegistryService.nure.ua/", name = "deleteServiceResponse")
    public JAXBElement<DeleteServiceResponse> createDeleteServiceResponse(DeleteServiceResponse value) {
        return new JAXBElement<DeleteServiceResponse>(_DeleteServiceResponse_QNAME, DeleteServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllServices }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllServices }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServiceImplementation.RegistryService.nure.ua/", name = "getAllServices")
    public JAXBElement<GetAllServices> createGetAllServices(GetAllServices value) {
        return new JAXBElement<GetAllServices>(_GetAllServices_QNAME, GetAllServices.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllServicesResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllServicesResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServiceImplementation.RegistryService.nure.ua/", name = "getAllServicesResponse")
    public JAXBElement<GetAllServicesResponse> createGetAllServicesResponse(GetAllServicesResponse value) {
        return new JAXBElement<GetAllServicesResponse>(_GetAllServicesResponse_QNAME, GetAllServicesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceByName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetServiceByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServiceImplementation.RegistryService.nure.ua/", name = "getServiceByName")
    public JAXBElement<GetServiceByName> createGetServiceByName(GetServiceByName value) {
        return new JAXBElement<GetServiceByName>(_GetServiceByName_QNAME, GetServiceByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetServiceByNameResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetServiceByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServiceImplementation.RegistryService.nure.ua/", name = "getServiceByNameResponse")
    public JAXBElement<GetServiceByNameResponse> createGetServiceByNameResponse(GetServiceByNameResponse value) {
        return new JAXBElement<GetServiceByNameResponse>(_GetServiceByNameResponse_QNAME, GetServiceByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterService }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterService }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServiceImplementation.RegistryService.nure.ua/", name = "registerService")
    public JAXBElement<RegisterService> createRegisterService(RegisterService value) {
        return new JAXBElement<RegisterService>(_RegisterService_QNAME, RegisterService.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterServiceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RegisterServiceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServiceImplementation.RegistryService.nure.ua/", name = "registerServiceResponse")
    public JAXBElement<RegisterServiceResponse> createRegisterServiceResponse(RegisterServiceResponse value) {
        return new JAXBElement<RegisterServiceResponse>(_RegisterServiceResponse_QNAME, RegisterServiceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateServiceStatus }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateServiceStatus }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServiceImplementation.RegistryService.nure.ua/", name = "updateServiceStatus")
    public JAXBElement<UpdateServiceStatus> createUpdateServiceStatus(UpdateServiceStatus value) {
        return new JAXBElement<UpdateServiceStatus>(_UpdateServiceStatus_QNAME, UpdateServiceStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateServiceStatusResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateServiceStatusResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ServiceImplementation.RegistryService.nure.ua/", name = "updateServiceStatusResponse")
    public JAXBElement<UpdateServiceStatusResponse> createUpdateServiceStatusResponse(UpdateServiceStatusResponse value) {
        return new JAXBElement<UpdateServiceStatusResponse>(_UpdateServiceStatusResponse_QNAME, UpdateServiceStatusResponse.class, null, value);
    }

}
