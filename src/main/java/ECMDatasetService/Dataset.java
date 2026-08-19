package ECMDatasetService;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de dataset complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dataset"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="datasetBuilder" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="datasetDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="datasetImpl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="datasetPK" type="{http://ws.dataservice.ecm.technology.totvs.com/}datasetPK" minOccurs="0"/&gt;
 *         &lt;element name="draft" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="journalingAdherence" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="lastRemoteSync" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="lastReset" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="listId" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="mobileCache" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="offlineMobileCache" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="resetType" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="serverOffline" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="syncDetails" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="syncStatus" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="updateInterval" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataset", propOrder = {
    "active",
    "datasetBuilder",
    "datasetDescription",
    "datasetImpl",
    "datasetPK",
    "draft",
    "journalingAdherence",
    "lastRemoteSync",
    "lastReset",
    "listId",
    "mobileCache",
    "offlineMobileCache",
    "resetType",
    "serverOffline",
    "syncDetails",
    "syncStatus",
    "type",
    "updateInterval"
})
public class Dataset {

    protected Boolean active;
    protected String datasetBuilder;
    protected String datasetDescription;
    protected String datasetImpl;
    protected DatasetPK datasetPK;
    protected Boolean draft;
    protected Integer journalingAdherence;
    protected Long lastRemoteSync;
    protected Long lastReset;
    protected Integer listId;
    protected Boolean mobileCache;
    protected Boolean offlineMobileCache;
    protected Integer resetType;
    protected Boolean serverOffline;
    protected String syncDetails;
    protected Integer syncStatus;
    protected String type;
    protected Long updateInterval;

    /**
     * Obtém o valor da propriedade active.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isActive() {
        return active;
    }

    /**
     * Define o valor da propriedade active.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setActive(Boolean value) {
        this.active = value;
    }

    /**
     * Obtém o valor da propriedade datasetBuilder.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatasetBuilder() {
        return datasetBuilder;
    }

    /**
     * Define o valor da propriedade datasetBuilder.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatasetBuilder(String value) {
        this.datasetBuilder = value;
    }

    /**
     * Obtém o valor da propriedade datasetDescription.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatasetDescription() {
        return datasetDescription;
    }

    /**
     * Define o valor da propriedade datasetDescription.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatasetDescription(String value) {
        this.datasetDescription = value;
    }

    /**
     * Obtém o valor da propriedade datasetImpl.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatasetImpl() {
        return datasetImpl;
    }

    /**
     * Define o valor da propriedade datasetImpl.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatasetImpl(String value) {
        this.datasetImpl = value;
    }

    /**
     * Obtém o valor da propriedade datasetPK.
     * 
     * @return
     *     possible object is
     *     {@link DatasetPK }
     *     
     */
    public DatasetPK getDatasetPK() {
        return datasetPK;
    }

    /**
     * Define o valor da propriedade datasetPK.
     * 
     * @param value
     *     allowed object is
     *     {@link DatasetPK }
     *     
     */
    public void setDatasetPK(DatasetPK value) {
        this.datasetPK = value;
    }

    /**
     * Obtém o valor da propriedade draft.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDraft() {
        return draft;
    }

    /**
     * Define o valor da propriedade draft.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDraft(Boolean value) {
        this.draft = value;
    }

    /**
     * Obtém o valor da propriedade journalingAdherence.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getJournalingAdherence() {
        return journalingAdherence;
    }

    /**
     * Define o valor da propriedade journalingAdherence.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setJournalingAdherence(Integer value) {
        this.journalingAdherence = value;
    }

    /**
     * Obtém o valor da propriedade lastRemoteSync.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLastRemoteSync() {
        return lastRemoteSync;
    }

    /**
     * Define o valor da propriedade lastRemoteSync.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLastRemoteSync(Long value) {
        this.lastRemoteSync = value;
    }

    /**
     * Obtém o valor da propriedade lastReset.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLastReset() {
        return lastReset;
    }

    /**
     * Define o valor da propriedade lastReset.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLastReset(Long value) {
        this.lastReset = value;
    }

    /**
     * Obtém o valor da propriedade listId.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getListId() {
        return listId;
    }

    /**
     * Define o valor da propriedade listId.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setListId(Integer value) {
        this.listId = value;
    }

    /**
     * Obtém o valor da propriedade mobileCache.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMobileCache() {
        return mobileCache;
    }

    /**
     * Define o valor da propriedade mobileCache.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMobileCache(Boolean value) {
        this.mobileCache = value;
    }

    /**
     * Obtém o valor da propriedade offlineMobileCache.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isOfflineMobileCache() {
        return offlineMobileCache;
    }

    /**
     * Define o valor da propriedade offlineMobileCache.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setOfflineMobileCache(Boolean value) {
        this.offlineMobileCache = value;
    }

    /**
     * Obtém o valor da propriedade resetType.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getResetType() {
        return resetType;
    }

    /**
     * Define o valor da propriedade resetType.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setResetType(Integer value) {
        this.resetType = value;
    }

    /**
     * Obtém o valor da propriedade serverOffline.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isServerOffline() {
        return serverOffline;
    }

    /**
     * Define o valor da propriedade serverOffline.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setServerOffline(Boolean value) {
        this.serverOffline = value;
    }

    /**
     * Obtém o valor da propriedade syncDetails.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSyncDetails() {
        return syncDetails;
    }

    /**
     * Define o valor da propriedade syncDetails.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSyncDetails(String value) {
        this.syncDetails = value;
    }

    /**
     * Obtém o valor da propriedade syncStatus.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSyncStatus() {
        return syncStatus;
    }

    /**
     * Define o valor da propriedade syncStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSyncStatus(Integer value) {
        this.syncStatus = value;
    }

    /**
     * Obtém o valor da propriedade type.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define o valor da propriedade type.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Obtém o valor da propriedade updateInterval.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUpdateInterval() {
        return updateInterval;
    }

    /**
     * Define o valor da propriedade updateInterval.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUpdateInterval(Long value) {
        this.updateInterval = value;
    }

}
