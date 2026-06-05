# Application
application é o arquivo de configuração do spring-boot,
ele pode ser criado com 
dois tipos:
    - .propries
    - .yml

## configurações feitas ate agora
Usando um arquivo .yml foi configurado:
    - **application.name** o nome da aplicação para o spring boot
    - **datasource** configurações do banco de dados:
        - url: jdbc:h2:mem:products # url para o db
        - username: sa # usuario
        - password: password # senha do db
        - jpa.database-platform: diz o db usado para o jpa #org.hibernate.dialect.H2Dialect