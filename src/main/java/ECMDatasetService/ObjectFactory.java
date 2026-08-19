package ECMDatasetService;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws.fluig.ECMDatasetService package. 
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

    private final static QName _Exception_QNAME = new QName("http://ws.dataservice.ecm.technology.totvs.com/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws.fluig.ECMDatasetService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link FormDatasetDTO }
     * 
     */
    public FormDatasetDTO createFormDatasetDTO() {
        return new FormDatasetDTO();
    }

    /**
     * Create an instance of {@link Dataset }
     * 
     */
    public Dataset createDataset() {
        return new Dataset();
    }

    /**
     * Create an instance of {@link DatasetPK }
     * 
     */
    public DatasetPK createDatasetPK() {
        return new DatasetPK();
    }

    /**
     * Create an instance of {@link SearchConstraintDto }
     * 
     */
    public SearchConstraintDto createSearchConstraintDto() {
        return new SearchConstraintDto();
    }

    /**
     * Create an instance of {@link DatasetDto }
     * 
     */
    public DatasetDto createDatasetDto() {
        return new DatasetDto();
    }

    /**
     * Create an instance of {@link ValuesDto }
     * 
     */
    public ValuesDto createValuesDto() {
        return new ValuesDto();
    }

    /**
     * Create an instance of {@link FormDatasetDTOArray }
     * 
     */
    public FormDatasetDTOArray createFormDatasetDTOArray() {
        return new FormDatasetDTOArray();
    }

    /**
     * Create an instance of {@link SearchConstraintDtoArray }
     * 
     */
    public SearchConstraintDtoArray createSearchConstraintDtoArray() {
        return new SearchConstraintDtoArray();
    }

    /**
     * Create an instance of {@link AnyTypeArray }
     * 
     */
    public AnyTypeArray createAnyTypeArray() {
        return new AnyTypeArray();
    }

    /**
     * Create an instance of {@link StringArray }
     * 
     */
    public StringArray createStringArray() {
        return new StringArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}
     */
    @XmlElementDecl(namespace = "http://ws.dataservice.ecm.technology.totvs.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}

