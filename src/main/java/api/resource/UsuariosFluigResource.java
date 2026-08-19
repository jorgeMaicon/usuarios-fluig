package api.resource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import api.service.ColleagueService;

@Path("usuarios-fluig")
@Consumes(MediaType.APPLICATION_JSON)
public class UsuariosFluigResource {

    private final ColleagueService colleagueService = new ColleagueService();

    @GET
    @Path("/dados")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarDados() {
        try {
            return Response.ok(colleagueService.listarColleagueTempoReal()).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao consultar dataset colleague: " + e.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }

    @GET
    @Path("/exportar")
    @Produces("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public Response exportarExcel() {
        try {
            byte[] arquivo = colleagueService.exportarColleagueExcelTempoReal();
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String nomeArquivo = "usuarios_fluig_completo_" + timestamp + ".xlsx";

            return Response.ok(arquivo)
                    .header("Content-Disposition", "attachment; filename=\"" + nomeArquivo + "\"")
                    .header("Content-Length", arquivo.length)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao exportar Excel do dataset colleague: " + e.getMessage())
                    .type(MediaType.TEXT_PLAIN)
                    .build();
        }
    }
}
