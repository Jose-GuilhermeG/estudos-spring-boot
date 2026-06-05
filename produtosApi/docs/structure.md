# Estrutura do projeto
```
└── 📁produtosApi
    └── 📁.mvn # pasta de gerenciamento do mvn (gerenciador de pacotes)
        └── 📁wrapper
            ├── maven-wrapper.properties
    └── 📁docs # docs
        ├── structure.md
    └── 📁src
        └── 📁main # aplicação
            └── 📁java
                └── 📁io
                    └── 📁example
                        └── 📁com
                            └── 📁produtosApi
                                ├── ProdutosApiApplication.java
            └── 📁resources
                ├── application.properties # arquivo de configurações do spring boot
        └── 📁test # testes unitarios
            └── 📁java
                └── 📁io
                    └── 📁example
                        └── 📁com
                            └── 📁produtosApi
                                ├── ProdutosApiApplicationTests.java
    └── 📁target # arquivos compilados e deps
        └── 📁classes
            └── 📁io
                └── 📁example
                    └── 📁com
                        └── 📁produtosApi
                            ├── ProdutosApiApplication.class
            ├── application.properties
        └── 📁generated-sources
            └── 📁annotations
    ├── .gitattributes
    ├── HELP.md
    ├── mvnw
    ├── mvnw.cmd
    └── pom.xml #arquivo responsavel pelas deps
```