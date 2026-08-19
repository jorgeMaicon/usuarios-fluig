package api.service;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ECMDatasetService.DatasetDto;
import ECMDatasetService.SearchConstraintDtoArray;
import ECMDatasetService.StringArray;
import api.client.FluigServiceClientFactory;
import api.config.ConfigReader;

public class ColleagueService {

    private static final int COMPANY_ID = ConfigReader.getCompanyId();
    private static final String LOGIN = ConfigReader.getLogin();
    private static final String PASSWORD = ConfigReader.getPassword();

    public List<Map<String, Object>> listarColleagueTempoReal() throws Exception {
        return consultarDatasetColleague().registros;
    }

    public byte[] exportarColleagueExcelTempoReal() throws Exception {
        DatasetResult resultado = consultarDatasetColleague();

        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("colleague");

            if (resultado.registros.isEmpty()) {
                Row row = sheet.createRow(0);
                row.createCell(0).setCellValue("Sem registros no dataset colleague");
            } else {
                Row header = sheet.createRow(0);
                for (int c = 0; c < resultado.colunas.size(); c++) {
                    Cell cell = header.createCell(c);
                    cell.setCellValue(resultado.colunas.get(c));
                }

                for (int r = 0; r < resultado.registros.size(); r++) {
                    Row dataRow = sheet.createRow(r + 1);
                    Map<String, Object> registro = resultado.registros.get(r);
                    for (int c = 0; c < resultado.colunas.size(); c++) {
                        String coluna = resultado.colunas.get(c);
                        Object valor = registro.get(coluna);
                        dataRow.createCell(c).setCellValue(valor == null ? "" : String.valueOf(valor));
                    }
                }

                for (int c = 0; c < resultado.colunas.size(); c++) {
                    sheet.autoSizeColumn(c);
                }
            }

            workbook.write(output);
            return output.toByteArray();
        }
    }

    private DatasetResult consultarDatasetColleague() throws Exception {
        StringArray fields = new StringArray();
        SearchConstraintDtoArray constraints = new SearchConstraintDtoArray();
        StringArray order = new StringArray();

        DatasetDto dataset = FluigServiceClientFactory.getDatasetService()
            .getDataset(COMPANY_ID, LOGIN, PASSWORD, "colleague", fields, constraints, order);

        // Buscar também o dataset fdn_userdata para extrair idprotheus por USER_TENANT_ID
        DatasetDto fdnDataset = FluigServiceClientFactory.getDatasetService()
            .getDataset(COMPANY_ID, LOGIN, PASSWORD, "fdn_userdata", new StringArray(), new SearchConstraintDtoArray(), new StringArray());

        if (dataset == null) {
            throw new IllegalStateException("Dataset colleague nao retornou dados.");
        }

        List<String> colunas = new ArrayList<>();
        if (dataset.getColumns() != null && !dataset.getColumns().isEmpty()) {
            for (int i = 0; i < dataset.getColumns().size(); i++) {
                colunas.add(normalizarNomeColuna(dataset.getColumns().get(i), i));
            }
        }

        // Montar mapa USER_TENANT_ID -> idprotheus (DATA_VALUE) a partir de fdn_userdata
        Map<String, String> idProtheusByUserTenant = new HashMap<>();
        if (fdnDataset != null && fdnDataset.getValues() != null) {
            // construir índice de colunas do fdn
            List<String> fdnCols = new ArrayList<>();
            if (fdnDataset.getColumns() != null) {
                for (int i = 0; i < fdnDataset.getColumns().size(); i++) {
                    fdnCols.add(fdnDataset.getColumns().get(i) == null ? "" : fdnDataset.getColumns().get(i).toString().trim());
                }
            }

            int idxUserTenant = -1;
            int idxDataKey = -1;
            int idxDataValue = -1;
            for (int i = 0; i < fdnCols.size(); i++) {
                String c = fdnCols.get(i).toUpperCase();
                if (c.equals("USER_TENANT_ID")) idxUserTenant = i;
                if (c.equals("DATA_KEY")) idxDataKey = i;
                if (c.equals("DATA_VALUE")) idxDataValue = i;
            }

            for (int i = 0; i < fdnDataset.getValues().size(); i++) {
                List<Object> valores = fdnDataset.getValues().get(i).getValue();
                String userTenantId = null;
                String dataKey = null;
                String dataValue = null;
                if (idxUserTenant >= 0 && idxUserTenant < valores.size() && valores.get(idxUserTenant) != null)
                    userTenantId = String.valueOf(valores.get(idxUserTenant));
                if (idxDataKey >= 0 && idxDataKey < valores.size() && valores.get(idxDataKey) != null)
                    dataKey = String.valueOf(valores.get(idxDataKey));
                if (idxDataValue >= 0 && idxDataValue < valores.size() && valores.get(idxDataValue) != null)
                    dataValue = String.valueOf(valores.get(idxDataValue));

                if (userTenantId != null && dataKey != null && dataKey.equalsIgnoreCase("idprotheus") && dataValue != null) {
                    idProtheusByUserTenant.put(userTenantId, dataValue);
                }
            }
        }

        List<Map<String, Object>> registros = new ArrayList<>();
        if (dataset.getValues() != null) {
            for (int i = 0; i < dataset.getValues().size(); i++) {
                Map<String, Object> linha = new LinkedHashMap<>();
                List<Object> valores = dataset.getValues().get(i).getValue();

                for (int j = 0; j < valores.size(); j++) {
                    String coluna = j < colunas.size() ? colunas.get(j) : normalizarNomeColuna(null, j);
                    Object valor = valores.get(j);
                    linha.put(coluna, valor);
                }

                // relacionar com fdn_userdata usando userTenantId / USER_TENANT_ID
                Object userTenantObj = linha.get("userTenantId");
                if (userTenantObj == null) userTenantObj = linha.get("USER_TENANT_ID");
                String userTenantKey = userTenantObj == null ? null : String.valueOf(userTenantObj);
                String idProtheus = null;
                if (userTenantKey != null) {
                    idProtheus = idProtheusByUserTenant.get(userTenantKey);
                }

                linha.put("has_idprotheus", idProtheus != null);
                linha.put("idprotheus", idProtheus);

                registros.add(linha);
            }
        }

        if (colunas.isEmpty() && !registros.isEmpty()) {
            colunas.addAll(new LinkedHashSet<>(registros.get(0).keySet()));
        }

        // Garantir que as colunas adicionadas existam no cabeçalho
        if (!colunas.contains("has_idprotheus")) colunas.add("has_idprotheus");
        if (!colunas.contains("idprotheus")) colunas.add("idprotheus");

        return new DatasetResult(colunas, registros);
    }

    private static class DatasetResult {
        private final List<String> colunas;
        private final List<Map<String, Object>> registros;

        private DatasetResult(List<String> colunas, List<Map<String, Object>> registros) {
            this.colunas = colunas;
            this.registros = registros;
        }
    }

    private String normalizarNomeColuna(String nomeColuna, int indice) {
        if (nomeColuna == null || nomeColuna.trim().isEmpty()) {
            return "COL_" + indice;
        }
        return nomeColuna.trim();
    }
}
