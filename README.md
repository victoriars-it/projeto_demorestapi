# demorestAPI — API de Tarefas 

**Aluno:** Victoria Resende — **RU 4612869**  
**Faculdade:** UNINTER — **Disciplina:** Desenvolvimento Web - Back End

API RESTful para **gerenciar tarefas**

---

## Tecnologias
- Java 17 • Spring Boot 3 • Spring Web • Spring Data JPA • Jakarta Validation  
- MySQL 8

---

## Como rodar

1. **Configurar o MySQL** (local):
   - Criar/usar o DB `projeto_uninter`
2. **`src/main/resources/application.properties`**:
   ```properties
   spring.datasource.url=jdbc:mysql://127.0.0.1:3306/projeto_uninter?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true
   spring.datasource.username=root
   spring.datasource.password=root
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
