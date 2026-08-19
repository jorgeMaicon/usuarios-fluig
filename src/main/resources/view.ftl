<link rel="stylesheet" href="https://cdn.datatables.net/1.13.8/css/jquery.dataTables.min.css" />
<link rel="stylesheet" href="/usuarios-fluig/resources/css/usuarios-fluig.css" />

<div id="usuariosFluigApp" class="usuarios-fluig-app">
  <main class="container">
    <header class="topo">
      <h2 id="tituloPagina">Cadastro de Usuários Fluig</h2>
      <div class="acoes-topo">
        <button id="btnExportar" type="button">Exportar Cadastro Completo</button>
        <div class="ocultar-colunas-wrapper">
          <button id="btnOcultarColunas" type="button">Ocultar/Exibir Colunas</button>
          <div id="painelOcultarColunas" class="painel-ocultar hidden" aria-hidden="true">
            <div id="listaOcultarColunas" class="lista-ocultar-colunas"></div>
          </div>
        </div>
      </div>
    </header>

    <section class="indicadores">
      <article class="indicador-card">
        <span id="lblIndicadorTotalUsuarios" class="indicador-label">Usuários Cadastrados</span>
        <strong id="indicadorTotalUsuarios" class="indicador-valor">0</strong>
      </article>
      <article class="indicador-card">
        <span id="lblIndicadorUsuariosAtivos" class="indicador-label">Usuários Ativos</span>
        <strong id="indicadorUsuariosAtivos" class="indicador-valor">0</strong>
      </article>
      <article class="indicador-card">
        <span id="lblIndicadorUsuariosInativos" class="indicador-label">Usuários Inativos</span>
        <strong id="indicadorUsuariosInativos" class="indicador-valor">0</strong>
      </article>
      <article class="indicador-card">
        <span id="lblIndicadorUsuariosAdmin" class="indicador-label">Usuários admin</span>
        <strong id="indicadorUsuariosAdmin" class="indicador-valor">0</strong>
      </article>
      <article class="indicador-card">
        <span id="lblIndicadorUsuariosSemIdprotheus" class="indicador-label">Usuários Sem idprotheus</span>
        <strong id="indicadorUsuariosSemIdprotheus" class="indicador-valor">0</strong>
      </article>
    </section>

    <section class="tabela-wrapper">
      <div id="loadingTabela" class="loading-overlay hidden" aria-live="polite">
        <div class="loading-card">
          <span class="spinner" aria-hidden="true"></span>
          <span id="loadingTabelaTexto">Carregando registros...</span>
        </div>
      </div>
      <table id="tabelaColleague" class="display" style="width: 100%;">
        <thead>
          <tr id="cabecalhoColleague"></tr>
        </thead>
        <tbody></tbody>
      </table>
    </section>
  </main>
</div>

<script>
  window.USUARIOS_FLUIG_BASE_URL = '/usuarios-fluig';
</script>
<script src="https://cdn.datatables.net/1.13.8/js/jquery.dataTables.min.js"></script>
<script src="/usuarios-fluig/resources/js/usuarios-fluig.js"></script>
