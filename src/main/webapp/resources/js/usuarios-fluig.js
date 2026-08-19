(function () {
  if (window.USUARIOS_FLUIG_APP_INITIALIZED) {
    return;
  }
  window.USUARIOS_FLUIG_APP_INITIALIZED = true;

  let datatable = null;
  const APP_BASE_URL = obterBaseUrl();
  const COLUNAS_OCULTAS_INICIAIS = [
    'colleaguePK.companyId',
    'emailHtml',
    'defaultLanguage',
    'currentProject',
    'especializationArea',
    'groupId',
    'volumeId',
    'extensionNr'
  ];
  const IDIOMA_USUARIO = obterIdiomaUsuario();
  const TRADUCOES = {
    pt_BR: {
      pageTitle: 'Cadastro de Usuários Fluig',
      btnExport: 'Exportar Cadastro Completo',
      btnExporting: 'Exportando...',
      btnHideShowColumns: 'Ocultar/Exibir Colunas',
      indicatorTotalUsers: 'Usuários Cadastrados',
      indicatorActiveUsers: 'Usuários Ativos',
      indicatorInactiveUsers: 'Usuários Inativos',
      indicatorAdminUsers: 'Usuários admin',
      indicatorUsersWithoutIdprotheus: 'Usuários Sem idprotheus',
      loadingRecords: 'Carregando registros...',
      activeYes: 'SIM',
      activeNo: 'NÃO',
      showColumnAria: 'Exibir coluna',
      noDataColumnTitle: 'Sem dados',
      columns: {
        'colleaguePK.companyId': 'ID Empresa',
        'colleaguePK.colleagueId': 'ID Colaborador',
        colleagueName: 'Nome do Colaborador',
        mail: 'E-mail',
        login: 'Login',
        ACTIVE: 'ATIVO',
        adminUser: 'Usuário Admin',
        has_idprotheus: 'Tem ID Protheus',
        idprotheus: 'ID Protheus',
        emailHtml: 'E-mail HTML',
        defaultLanguage: 'Idioma Padrão',
        currentProject: 'Projeto Atual',
        especializationArea: 'Área de Especialização',
        groupId: 'ID do Grupo',
        userTenantId: 'ID do Tenant do Usuário',
        volumeId: 'ID do Volume',
        extensionNr: 'Ramal'
      },
      errorsLoadDataPrefix: 'Falha ao carregar dataset colleague.',
      errorsExportPrefix: 'Falha ao iniciar exportacao do Excel.',
      errorsJsonEndpoint: 'Nao foi possivel obter JSON do endpoint de dados.',
      errorsExportFile: 'Nao foi possivel obter o arquivo de exportacao.',
      errorsUnexpectedData: 'Resposta inesperada ao carregar dados.',
      datatable: {
        emptyTable: 'Nenhum registro encontrado no dataset colleague',
        search: 'Buscar:',
        lengthMenu: 'Mostrar _MENU_ registros',
        info: 'Mostrando _START_ a _END_ de _TOTAL_ registros',
        paginate: {
          first: 'Primeiro',
          previous: 'Anterior',
          next: 'Proximo',
          last: 'Ultimo'
        }
      }
    },
    en_US: {
      pageTitle: 'Fluig User Registry',
      btnExport: 'Export Full Registry',
      btnExporting: 'Exporting...',
      btnHideShowColumns: 'Hide/Show Columns',
      indicatorTotalUsers: 'Registered Users',
      indicatorActiveUsers: 'Active Users',
      indicatorInactiveUsers: 'Inactive Users',
      indicatorAdminUsers: 'Admin Users',
      indicatorUsersWithoutIdprotheus: 'Users Without idprotheus',
      loadingRecords: 'Loading records...',
      activeYes: 'YES',
      activeNo: 'NO',
      showColumnAria: 'Show column',
      noDataColumnTitle: 'No data',
      columns: {
        'colleaguePK.companyId': 'Company ID',
        'colleaguePK.colleagueId': 'Colleague ID',
        colleagueName: 'Colleague Name',
        mail: 'E-mail',
        login: 'Login',
        ACTIVE: 'ACTIVE',
        adminUser: 'Admin User',
        has_idprotheus: 'Has ID Protheus',
        idprotheus: 'ID Protheus',
        emailHtml: 'HTML E-mail',
        defaultLanguage: 'Default Language',
        currentProject: 'Current Project',
        especializationArea: 'Specialization Area',
        groupId: 'Group ID',
        userTenantId: 'User Tenant ID',
        volumeId: 'Volume ID',
        extensionNr: 'Extension'
      },
      errorsLoadDataPrefix: 'Failed to load colleague dataset.',
      errorsExportPrefix: 'Failed to start Excel export.',
      errorsJsonEndpoint: 'Could not retrieve JSON from data endpoint.',
      errorsExportFile: 'Could not retrieve export file.',
      errorsUnexpectedData: 'Unexpected response while loading data.',
      datatable: {
        emptyTable: 'No records found in colleague dataset',
        search: 'Search:',
        lengthMenu: 'Show _MENU_ records',
        info: 'Showing _START_ to _END_ of _TOTAL_ records',
        paginate: {
          first: 'First',
          previous: 'Previous',
          next: 'Next',
          last: 'Last'
        }
      }
    },
    es: {
      pageTitle: 'Registro de Usuarios Fluig',
      btnExport: 'Exportar Registro Completo',
      btnExporting: 'Exportando...',
      btnHideShowColumns: 'Ocultar/Mostrar Columnas',
      indicatorTotalUsers: 'Usuarios Registrados',
      indicatorActiveUsers: 'Usuarios Activos',
      indicatorInactiveUsers: 'Usuarios Inactivos',
      indicatorAdminUsers: 'Usuarios admin',
      indicatorUsersWithoutIdprotheus: 'Usuarios Sin idprotheus',
      loadingRecords: 'Cargando registros...',
      activeYes: 'SÍ',
      activeNo: 'NO',
      showColumnAria: 'Mostrar columna',
      noDataColumnTitle: 'Sin datos',
      columns: {
        'colleaguePK.companyId': 'ID de Empresa',
        'colleaguePK.colleagueId': 'ID de Colaborador',
        colleagueName: 'Nombre del Colaborador',
        mail: 'Correo',
        login: 'Login',
        ACTIVE: 'ACTIVO',
        adminUser: 'Usuario Admin',
        has_idprotheus: 'Tiene ID Protheus',
        idprotheus: 'ID Protheus',
        emailHtml: 'Correo HTML',
        defaultLanguage: 'Idioma Predeterminado',
        currentProject: 'Proyecto Actual',
        especializationArea: 'Área de Especialización',
        groupId: 'ID del Grupo',
        userTenantId: 'ID de Tenant del Usuario',
        volumeId: 'ID del Volumen',
        extensionNr: 'Extensión'
      },
      errorsLoadDataPrefix: 'Error al cargar el dataset colleague.',
      errorsExportPrefix: 'Error al iniciar la exportacion de Excel.',
      errorsJsonEndpoint: 'No se pudo obtener JSON del endpoint de datos.',
      errorsExportFile: 'No se pudo obtener el archivo de exportacion.',
      errorsUnexpectedData: 'Respuesta inesperada al cargar datos.',
      datatable: {
        emptyTable: 'No se encontraron registros en el dataset colleague',
        search: 'Buscar:',
        lengthMenu: 'Mostrar _MENU_ registros',
        info: 'Mostrando _START_ a _END_ de _TOTAL_ registros',
        paginate: {
          first: 'Primero',
          previous: 'Anterior',
          next: 'Siguiente',
          last: 'Ultimo'
        }
      }
    }
  };

  function obterIdiomaUsuario() {
    let idioma = 'pt_BR';

    try {
      idioma = String(window.parent && window.parent.wcmlocation ? window.parent.wcmlocation : 'pt_BR');
    } catch (error) {
      idioma = 'pt_BR';
    }

    const normalizado = idioma.trim().toLowerCase();
    if (normalizado.indexOf('en') === 0) {
      return 'en_US';
    }
    if (normalizado.indexOf('es') === 0) {
      return 'es';
    }
    return 'pt_BR';
  }

  function t(chave) {
    const dicionario = TRADUCOES[IDIOMA_USUARIO] || TRADUCOES.pt_BR;
    return dicionario[chave];
  }

  function linguagemDataTable() {
    return t('datatable');
  }

  function definirTexto(id, texto) {
    const elemento = document.getElementById(id);
    if (elemento) {
      elemento.textContent = texto;
    }
  }

  function aplicarTextosTela() {
    definirTexto('tituloPagina', t('pageTitle'));
    definirTexto('btnExportar', t('btnExport'));
    definirTexto('btnOcultarColunas', t('btnHideShowColumns'));
    definirTexto('lblIndicadorTotalUsuarios', t('indicatorTotalUsers'));
    definirTexto('lblIndicadorUsuariosAtivos', t('indicatorActiveUsers'));
    definirTexto('lblIndicadorUsuariosInativos', t('indicatorInactiveUsers'));
    definirTexto('lblIndicadorUsuariosAdmin', t('indicatorAdminUsers'));
    definirTexto('lblIndicadorUsuariosSemIdprotheus', t('indicatorUsersWithoutIdprotheus'));
    definirTexto('loadingTabelaTexto', t('loadingRecords'));
  }
  
  function normalizarChave(coluna) {
    return String(coluna || '').trim().toUpperCase();
  }

  function obterBaseUrl() {
    if (window.USUARIOS_FLUIG_BASE_URL) {
      return String(window.USUARIOS_FLUIG_BASE_URL).replace(/\/+$/, '');
    }

    const path = window.location.pathname || '';
    const marcador = '/usuarios-fluig';
    const indice = path.indexOf(marcador);
    if (indice >= 0) {
      return path.substring(0, indice + marcador.length);
    }
    return '';
  }

  function montarUrl(recurso) {
    if (!recurso) {
      return APP_BASE_URL || '';
    }
    if (recurso.charAt(0) === '/') {
      return (APP_BASE_URL || '') + recurso;
    }
    return (APP_BASE_URL || '') + '/' + recurso;
  }

  function montarListaUrlsDados() {
    const urls = [
      montarUrl('/rest/usuarios-fluig/dados'),
      '/usuarios-fluig/rest/usuarios-fluig/dados',
      '/rest/usuarios-fluig/dados',
      'rest/usuarios-fluig/dados'
    ];

    return urls.filter(function (url, indice) {
      return url && urls.indexOf(url) === indice;
    });
  }

  function montarListaUrlsExportacao() {
    const urls = [
      montarUrl('/rest/usuarios-fluig/exportar'),
      '/usuarios-fluig/rest/usuarios-fluig/exportar',
      '/rest/usuarios-fluig/exportar',
      'rest/usuarios-fluig/exportar'
    ];

    return urls.filter(function (url, indice) {
      return url && urls.indexOf(url) === indice;
    });
  }

  function buscarJsonComFallback(urls, indice) {
    if (indice >= urls.length) {
      return Promise.reject(new Error(t('errorsJsonEndpoint')));
    }

    const url = urls[indice];
    return fetch(url, { method: 'GET' })
      .then(function (response) {
        if (!response.ok) {
          return buscarJsonComFallback(urls, indice + 1);
        }
        return response.text();
      })
      .then(function (texto) {
        if (typeof texto !== 'string') {
          return texto;
        }
        try {
          return JSON.parse(texto);
        } catch (erro) {
          return buscarJsonComFallback(urls, indice + 1);
        }
      });
  }

  function baixarArquivoComFallback(urls, indice) {
    if (indice >= urls.length) {
      return Promise.reject(new Error(t('errorsExportFile')));
    }

    const url = urls[indice];
    return fetch(url, { method: 'GET' })
      .then(function (response) {
        if (!response.ok) {
          return baixarArquivoComFallback(urls, indice + 1);
        }

        const contentType = String(response.headers.get('Content-Type') || '').toLowerCase();
        if (contentType.indexOf('text/html') >= 0 || contentType.indexOf('application/json') >= 0) {
          return baixarArquivoComFallback(urls, indice + 1);
        }

        return Promise.all([
          response.blob(),
          response.headers.get('Content-Disposition')
        ]).then(function (resultado) {
          const blob = resultado[0];
          const contentDisposition = resultado[1];
          return { blob: blob, contentDisposition: contentDisposition };
        });
      });
  }

  function colunaIniciaOculta(coluna) {
    const chave = normalizarChave(coluna);
    return COLUNAS_OCULTAS_INICIAIS.some(function (colunaOculta) {
      return normalizarChave(colunaOculta) === chave;
    });
  }

  function extrairColunas(dados) {
    const colunas = [];
    const mapa = {};

    dados.forEach(function (linha) {
      Object.keys(linha).forEach(function (chave) {
        if (!mapa[chave]) {
          mapa[chave] = true;
          colunas.push(chave);
        }
      });
    });

    return colunas;
  }

  function obterTituloColuna(coluna) {
    const mapaColunas = t('columns') || {};
    const chaves = Object.keys(mapaColunas);
    for (let i = 0; i < chaves.length; i++) {
      const chaveOriginal = chaves[i];
      if (normalizarChave(chaveOriginal) === normalizarChave(coluna)) {
        return mapaColunas[chaveOriginal];
      }
    }
    return coluna;
  }

  function interpretarBooleano(valor) {
    if (typeof valor === 'boolean') {
      return valor;
    }
    if (valor === null || valor === undefined) {
      return null;
    }

    const texto = String(valor).trim().toLowerCase();
    if (texto === 'true' || texto === '1' || texto === 'sim') {
      return true;
    }
    if (texto === 'false' || texto === '0' || texto === 'nao' || texto === 'não') {
      return false;
    }
    return null;
  }

  function encontrarNomeColuna(colunas, nomesPossiveis) {
    for (let i = 0; i < colunas.length; i++) {
      const coluna = colunas[i];
      const chave = normalizarChave(coluna);
      const encontrou = nomesPossiveis.some(function (nome) {
        return chave === normalizarChave(nome);
      });
      if (encontrou) {
        return coluna;
      }
    }
    return null;
  }

  function atualizarIndicadores(dados, colunas) {
    const totalUsuarios = dados.length;
    const colunaAtivo = encontrarNomeColuna(colunas, ['ACTIVE']);
    const colunaAdmin = encontrarNomeColuna(colunas, ['adminUser', 'ADMIN_USER']);
    let totalAtivos = 0;
    let totalInativos = 0;
    let totalAdmins = 0;

    let totalUsuariosSemIdprotheus = 0;
    const colunaHasIdprotheus = encontrarNomeColuna(colunas, ['has_idprotheus']);

    dados.forEach(function (item) {
      if (colunaAtivo) {
        const ativo = interpretarBooleano(item[colunaAtivo]);
        if (ativo === true) {
          totalAtivos += 1;
        } else if (ativo === false) {
          totalInativos += 1;
        }
      }

      if (colunaAdmin) {
        const admin = interpretarBooleano(item[colunaAdmin]);
        if (admin === true) {
          totalAdmins += 1;
        }
      }

      if (colunaHasIdprotheus) {
        const hasId = interpretarBooleano(item[colunaHasIdprotheus]);
        if (hasId === false || hasId === null) {
          totalUsuariosSemIdprotheus += 1;
        }
      }
    });

    document.getElementById('indicadorTotalUsuarios').textContent = String(totalUsuarios);
    document.getElementById('indicadorUsuariosAtivos').textContent = String(totalAtivos);
    document.getElementById('indicadorUsuariosInativos').textContent = String(totalInativos);
    document.getElementById('indicadorUsuariosAdmin').textContent = String(totalAdmins);
    document.getElementById('indicadorUsuariosSemIdprotheus').textContent = String(totalUsuariosSemIdprotheus);
  }

  function montarCabecalho(colunas) {
    const cabecalho = document.getElementById('cabecalhoColleague');
    cabecalho.innerHTML = '';
    colunas.forEach(function (coluna) {
      const th = document.createElement('th');
      th.textContent = obterTituloColuna(coluna);
      cabecalho.appendChild(th);
    });
  }

  function montarDefinicoesColunas(colunas) {
    return colunas.map(function (coluna) {
      return { title: obterTituloColuna(coluna) };
    });
  }

  function normalizarDados(dados, colunas) {
    return dados.map(function (item) {
      return colunas.map(function (coluna) {
        const valor = item[coluna];
        const chaveNormalizada = normalizarChave(coluna);

        if (chaveNormalizada === 'ACTIVE' || chaveNormalizada === 'HAS_IDPROTHEUS') {
          const ativo = interpretarBooleano(valor);
          if (ativo === true) {
            return '<span class="status-ativo status-ativo-sim">' + t('activeYes') + '</span>';
          }
          if (ativo === false) {
            return '<span class="status-ativo status-ativo-nao">' + t('activeNo') + '</span>';
          }
          return '';
        }

        return valor === null || valor === undefined ? '' : String(valor);
      });
    });
  }

  function alternarPainelColunas() {
    const painel = document.getElementById('painelOcultarColunas');
    painel.classList.toggle('hidden');
    painel.setAttribute('aria-hidden', painel.classList.contains('hidden') ? 'true' : 'false');
  }

  function esconderPainelAoClicarFora(evento) {
    const wrapper = document.querySelector('.ocultar-colunas-wrapper');
    const painel = document.getElementById('painelOcultarColunas');

    if (!wrapper.contains(evento.target)) {
      painel.classList.add('hidden');
      painel.setAttribute('aria-hidden', 'true');
    }
  }

  function montarControleOcultarColunas(colunas) {
    const lista = document.getElementById('listaOcultarColunas');
    lista.innerHTML = '';

    colunas.forEach(function (coluna, indice) {
      const item = document.createElement('label');
      item.className = 'item-coluna';

      const texto = document.createElement('span');
      texto.textContent = obterTituloColuna(coluna);

      const controle = document.createElement('input');
      controle.type = 'checkbox';
      controle.checked = datatable.column(indice).visible();
      controle.setAttribute('aria-label', t('showColumnAria') + ' ' + obterTituloColuna(coluna));

      controle.addEventListener('change', function () {
        datatable.column(indice).visible(controle.checked, false);
        datatable.columns.adjust().draw(false);
      });

      item.appendChild(controle);
      item.appendChild(texto);
      lista.appendChild(item);
    });
  }

  function carregarTabela() {
    setLoadingTabela(true, t('loadingRecords'));
    const urlsDados = montarListaUrlsDados();
    buscarJsonComFallback(urlsDados, 0)
      .then(function (dados) {
        if (!Array.isArray(dados)) {
          throw new Error(t('errorsUnexpectedData'));
        }

        const colunas = dados.length > 0 ? extrairColunas(dados) : [t('noDataColumnTitle')];
        atualizarIndicadores(dados, colunas);
        montarCabecalho(colunas);

        if ($.fn.dataTable && $.fn.dataTable.isDataTable('#tabelaColleague')) {
          $('#tabelaColleague').DataTable().destroy();
          $('#tabelaColleague tbody').empty();
        }

        if (datatable) {
          datatable.destroy();
          $('#tabelaColleague tbody').empty();
        }

        const linhas = dados.length > 0 ? normalizarDados(dados, colunas) : [];
        const definicoesColunas = montarDefinicoesColunas(colunas);
        const indicesOcultosIniciais = colunas.reduce(function (acumulado, coluna, indice) {
          if (colunaIniciaOculta(coluna)) {
            acumulado.push(indice);
          }
          return acumulado;
        }, []);

        datatable = $('#tabelaColleague').DataTable({
          data: linhas,
          columns: definicoesColunas,
          columnDefs: indicesOcultosIniciais.length > 0 ? [
            { targets: indicesOcultosIniciais, visible: false }
          ] : [],
          pageLength: 25,
          scrollX: true,
          autoWidth: false,
          deferRender: true,
          language: linguagemDataTable()
        });

        montarControleOcultarColunas(colunas);
      })
      .catch(function (error) {
        alert(t('errorsLoadDataPrefix') + ' ' + error.message);
      })
      .finally(function () {
        setLoadingTabela(false);
      });
  }

  function setLoadingTabela(ativo, texto) {
    const overlay = document.getElementById('loadingTabela');
    const label = document.getElementById('loadingTabelaTexto');

    if (texto) {
      label.textContent = texto;
    }
    overlay.classList.toggle('hidden', !ativo);
  }

  function setLoadingExportacao(ativo) {
    const botao = document.getElementById('btnExportar');
    botao.disabled = ativo;
    botao.textContent = ativo ? t('btnExporting') : t('btnExport');
  }

  function extrairNomeArquivo(contentDisposition) {
    if (!contentDisposition) {
      return 'usuarios_fluig_completo_' + gerarTimestampArquivo() + '.xlsx';
    }

    const matchUtf8 = contentDisposition.match(/filename\*=UTF-8''([^;]+)/i);
    if (matchUtf8 && matchUtf8[1]) {
      return decodeURIComponent(matchUtf8[1].replace(/["']/g, ''));
    }

    const matchSimples = contentDisposition.match(/filename="?([^"]+)"?/i);
    if (matchSimples && matchSimples[1]) {
      return matchSimples[1];
    }

    return 'usuarios_fluig_completo_' + gerarTimestampArquivo() + '.xlsx';
  }

  function gerarTimestampArquivo() {
    const agora = new Date();
    const yyyy = String(agora.getFullYear());
    const mm = String(agora.getMonth() + 1).padStart(2, '0');
    const dd = String(agora.getDate()).padStart(2, '0');
    const hh = String(agora.getHours()).padStart(2, '0');
    const mi = String(agora.getMinutes()).padStart(2, '0');
    const ss = String(agora.getSeconds()).padStart(2, '0');
    return yyyy + mm + dd + '_' + hh + mi + ss;
  }

  function configurarExportacao() {
    const botao = document.getElementById('btnExportar');
    botao.addEventListener('click', function () {
      setLoadingExportacao(true);

      const urlsExportacao = montarListaUrlsExportacao();
      baixarArquivoComFallback(urlsExportacao, 0)
        .then(function (resultado) {
          const blob = resultado.blob;
          const contentDisposition = resultado.contentDisposition;
          const nomeArquivo = extrairNomeArquivo(contentDisposition);
          const url = window.URL.createObjectURL(blob);
          const link = document.createElement('a');
          link.href = url;
          link.download = nomeArquivo;
          document.body.appendChild(link);
          link.click();
          document.body.removeChild(link);
          setTimeout(function () {
            window.URL.revokeObjectURL(url);
          }, 1000);
        })
        .catch(function (error) {
          alert(t('errorsExportPrefix') + ' ' + error.message);
        })
        .finally(function () {
          setLoadingExportacao(false);
        });
    });
  }

  function configurarOcultarColunas() {
    const botao = document.getElementById('btnOcultarColunas');
    botao.addEventListener('click', alternarPainelColunas);
    document.addEventListener('click', esconderPainelAoClicarFora);
  }

  document.addEventListener('DOMContentLoaded', function () {
    aplicarTextosTela();
    configurarExportacao();
    configurarOcultarColunas();
    carregarTabela();
  });
})();
