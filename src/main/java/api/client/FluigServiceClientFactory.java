package api.client;

import java.net.URL;

import ECMDatasetService.DatasetService;
import ECMDatasetService.ECMDatasetServiceService;
import api.config.ConfigReader;

public class FluigServiceClientFactory {

    private static final String BASE_URL = ConfigReader.getBaseUrlFluig();

    public static DatasetService getDatasetService() throws Exception {
        ECMDatasetServiceService service = new ECMDatasetServiceService(getWsdlUrl("ECMDatasetService"));
        return service.getDatasetServicePort();
    }

    private static URL getWsdlUrl(String service) throws Exception {
        return new URL(BASE_URL + "/webdesk/" + service + "?wsdl");
    }
}
