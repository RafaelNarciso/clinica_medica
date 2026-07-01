# Clínica Médica API

Uma API RESTful desenvolvida com **Spring Boot 4.1.0** para gerenciar uma clínica médica, incluindo cadastro e gerenciamento de pacientes e médicos.

## 📋 Características

- ✅ Gestão de **Pacientes** (CRUD completo)
- ✅ Gestão de **Médicos** (CRUD completo)
- ✅ Suporte a **Endereços** e **Telefones**
- ✅ Especialidades médicas
- ✅ Paginação de dados
- ✅ Validação de dados com Bean Validation
- ✅ CORS configurado
- ✅ Migrations automáticas com Flyway

## 🛠️ Tecnologias

- **Java 21**
- **Spring Boot 4.1.0**
- **Spring Data JPA** - Persistência de dados
- **Flyway** - Migrações de banco de dados
- **MySQL** - Banco de dados relacional
- **Lombok** - Redução de boilerplate code
- **Maven** - Gerenciador de dependências

## 📦 Estrutura do Projeto

```
src/main/java/com/example/demo/
├── controller/           # Controladores REST
│   ├── MedicoController.java
│   └── PacienteController.java
├── service/             # Lógica de negócio
├── repository/          # Acesso a dados
│   ├── MedicoRepository.java
│   └── PacienteRepository.java
├── model/               # Entidades JPA
│   ├── Medico.java
│   ├── Paciente.java
│   ├── Endereco.java
│   └── Telefone.java
├── dto/                 # Data Transfer Objects
│   ├── MedicoDto.java
│   ├── PacienteDto.java
│   ├── DadosListagemMedico.java
│   ├── DadosListagemPaciente.java
│   ├── DadosAtualizacaoMedico.java
│   └── DadosAtualizacaoPaciente.java
├── enumered/            # Enumerações
│   └── Especialidade.java
├── configuration/       # Configurações
│   └── CorsConfiguration.java
└── App.java            # Classe principal
```

## 🚀 Como Executar

### Pré-requisitos

- **Java 21+** instalado
- **MySQL 8.0+** rodando localmente
- **Maven 3.6+** (opcional, pode usar `mvnw`)

### Passo 1: Configurar Banco de Dados

1. Crie um banco de dados MySQL:
```sql
CREATE DATABASE medicina_api;
```

2. Configure as variáveis de ambiente para credenciais do banco:
```bash
export DB_USER_MY_SQL=seu_usuario
export DB_PASSWORD_MY_SQL=sua_senha
```

Ou configure no arquivo `application.properties`:
```properties
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

### Passo 2: Executar a Aplicação

**Com Maven wrapper (recomendado):**
```bash
cd App
./mvnw spring-boot:run
```

**Ou com Maven instalado globalmente:**
```bash
mvn spring-boot:run
```

A aplicação estará disponível em: **http://localhost:8080**

## 🔗 Endpoints da API

### Médicos

| Método | Endpoint           | Descrição |
|--------|--------------------|-----------|
| GET | `/v1/medicos`      | Listar todos os médicos (paginado) |
| GET | `/v1/medicos/{id}` | Obter detalhes de um médico |
| POST | `/v1/medicos`      | Criar novo médico |
| PUT | `/v1/medicos/{id}` | Atualizar médico |
| DELETE | `/v1/medicos/{id}` | Deletar médico |

### Pacientes

| Método | Endpoint          | Descrição |
|--------|-------------------|-----------|
| GET | `/v1/pacientes`   | Listar todos os pacientes (paginado) |
| GET | `/v1/pacientes/{id}` | Obter detalhes de um paciente |
| POST | `/v1/pacientes`      | Criar novo paciente |
| PUT | `/v1/pacientes/{id}` | Atualizar paciente |
| DELETE | `/v1/pacientes/{id}` | Deletar paciente |

## 📝 Exemplo de Requisição

### Criar um Médico
```bash
curl -X POST http://localhost:8080/v1/medicos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Dr. João Silva",
    "email": "joao@clinica.com",
    "crm": "123456",
    "especialidade": "CARDIOLOGIA",
    "telefone": {
      "ddd": "11",
      "numero": "998765432"
    },
    "endereco": {
      "logradouro": "Rua das Flores",
      "numero": "100",
      "complemento": "Apto 501",
      "bairro": "Centro",
      "cidade": "São Paulo",
      "uf": "SP",
      "cep": "01310100"
    }
  }'
```

### Listar Pacientes (com Paginação)
```bash
curl -X GET "http://localhost:8080/v1/pacientes?page=0&size=10"
```

## 🗄️ Migrações de Banco de Dados

As migrações são gerenciadas automaticamente pelo **Flyway**. Os scripts SQL estão em:
```
src/main/resources/db/migration/
```

Ao iniciar a aplicação, o Flyway executa automaticamente as migrações não aplicadas.

## ⚙️ Configuração

O arquivo `application.properties` contém as principais configurações:

```properties
# Banco de Dados
spring.datasource.url=jdbc:mysql://localhost:3306/medicina_api
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Validação
spring.data.web.pageable.serialization-mode=via-dto
```

## 🧪 Testes

Para executar os testes:
```bash
./mvnw test
```

## 📦 Build

Para gerar o JAR da aplicação:
```bash
./mvnw clean package
```

O arquivo JAR será gerado em `target/App-0.0.1-SNAPSHOT.jar`

Para executar o JAR:
```bash
java -jar target/App-0.0.1-SNAPSHOT.jar
```

## 🔒 CORS

A aplicação possui CORS configurado para aceitar requisições de múltiplas origens. Veja `CorsConfiguration.java` para mais detalhes.

## 🤝 Contribuindo

Contribuições são bem-vindas! Por favor, crie um branch para sua feature:
```bash
git checkout -b feature/sua-feature
git commit -am 'Add sua-feature'
git push origin feature/sua-feature
```

## 📄 Licença

Este projeto está sob licença MIT.

## 👤 Autor

- **Rafael Narciso** - [GitHub](https://github.com/RafaelNarciso)

## 📞 Suporte

Para dúvidas ou problemas, abra uma issue no repositório.

---

**Status do Projeto:** Em desenvolvimento 🚧
