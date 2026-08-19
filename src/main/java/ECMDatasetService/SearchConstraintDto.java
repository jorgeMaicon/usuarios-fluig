package ECMDatasetService;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de searchConstraintDto complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="searchConstraintDto"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contraintType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fieldName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="finalValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="initialValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="likeSearch" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchConstraintDto", propOrder = {
    "contraintType",
    "fieldName",
    "finalValue",
    "initialValue",
    "likeSearch"
})
public class SearchConstraintDto {

    protected String contraintType;
    protected String fieldName;
    protected String finalValue;
    protected String initialValue;
    protected boolean likeSearch;

    /**
     * Obtém o valor da propriedade contraintType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContraintType() {
        return contraintType;
    }

    /**
     * Define o valor da propriedade contraintType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContraintType(String value) {
        this.contraintType = value;
    }

    /**
     * Obtém o valor da propriedade fieldName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Define o valor da propriedade fieldName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFieldName(String value) {
        this.fieldName = value;
    }

    /**
     * Obtém o valor da propriedade finalValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinalValue() {
        return finalValue;
    }

    /**
     * Define o valor da propriedade finalValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinalValue(String value) {
        this.finalValue = value;
    }

    /**
     * Obtém o valor da propriedade initialValue.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitialValue() {
        return initialValue;
    }

    /**
     * Define o valor da propriedade initialValue.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitialValue(String value) {
        this.initialValue = value;
    }

    /**
     * Obtém o valor da propriedade likeSearch.
     * 
     */
    public boolean isLikeSearch() {
        return likeSearch;
    }

    /**
     * Define o valor da propriedade likeSearch.
     * 
     */
    public void setLikeSearch(boolean value) {
        this.likeSearch = value;
    }

}

