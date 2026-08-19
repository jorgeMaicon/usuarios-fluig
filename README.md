# usuarios-fluig

Widget Fluig para **consultar, visualizar e exportar** o cadastro de usuários (`dataset colleague`), com enriquecimento automático do campo **idprotheus** a partir do dataset `fdn_userdata`.

![Java](https://img.shields.io/badge/Java-11-blue)
![Maven](https://img.shields.io/badge/Maven-WAR-orange)
![Fluig](https://img.shields.io/badge/Fluig-Widget-green)

---

## O que faz

- Lista em tempo real todos os usuários do Fluig via SOAP (`ECMDatasetService`)
- Exibe indicadores: total, ativos, inativos, admins e usuários sem `idprotheus`
- Tabela interativa com busca, paginação e controle de colunas visíveis
- Exportação completa para Excel (`.xlsx`)
- Interface traduzida: **pt-BR**, **en-US** e **es**

## Arquitetura em resumo

```
Fluig Portal (widget)
        │
        ▼
REST API (/rest/usuarios-fluig)
        │
        ▼
ColleagueService ──SOAP──► Fluig (datasets colleague + fdn_userdata)
```

| Endpoint | Descrição |
|----------|-----------|
| `GET /rest/usuarios-fluig/dados` | JSON com todos os registros enriquecidos |
| `GET /rest/usuarios-fluig/exportar` | Download da planilha Excel |

Context root da aplicação: **`/usuarios-fluig`**

## Pré-requisitos

- Java 11+
- Maven 3.6+
- Ambiente Fluig com acesso ao serviço `ECMDatasetService`
- Usuário de integração com permissão para consultar datasets

## Configuração

1. Copie o arquivo de exemplo:

```bash
cp src/main/resources/config.properties.example src/main/resources/config.properties
```

2. Edite `config.properties` com os dados do seu tenant:

```properties
fluig.companyId=1
fluig.login=user_integracao
fluig.password=SUA_SENHA
fluig.baseUrl=https://seu-tenant.fluig.cloudtotvs.com.br/
```

> O arquivo `config.properties` **não é versionado** — mantenha credenciais apenas no ambiente local/servidor.

## Build

```bash
mvn clean package
```

Artefato gerado: `target/usuarios-fluig.war`

## Deploy

1. Implante o WAR no servidor de aplicação do Fluig
2. Registre/importe o widget usando `application.info`
3. Adicione o widget a uma página ou dashboard no portal

## Estrutura do projeto

```
src/main/
├── java/
│   ├── api/                    # REST, serviço, config, client SOAP
│   └── ECMDatasetService/      # Stubs JAX-WS (gerados)
├── resources/
│   ├── application.info        # Metadados do widget Fluig
│   ├── view.ftl / edit.ftl     # Templates FreeMarker
│   ├── config.properties*      # Credenciais (local, gitignored)
│   └── usuarios_fluig_*.properties  # i18n Fluig
└── webapp/
    ├── WEB-INF/                # web.xml, jboss-web.xml
    └── resources/
        ├── css/usuarios-fluig.css
        └── js/usuarios-fluig.js
```

## Stack

| Camada | Tecnologia |
|--------|------------|
| Backend | Java 11, JAX-RS, JAX-WS |
| Excel | Apache POI 5.x |
| Frontend | FreeMarker, jQuery, DataTables |
| Servidor | WildFly/JBoss (Fluig) |

## Licença

Projeto interno — consulte o responsável antes de redistribuir.
