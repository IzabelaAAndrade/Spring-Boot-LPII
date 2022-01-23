# Trabalho Prático: Spring Boot Java
Trabalho prático da disciplina de Linguagem de Programação II do CEFET-MG, voltado ao uso do framework SpringBoot integrado a Java. 
Atividade feita utilizando como referência o [curso de Spring Boot](https://www.youtube.com/watch?v=OHn1jLHGptw&list=PL8iIphQOyG-DHLpEx1TPItqJamy08fs1D) de Autoria de [Michelli Brito](https://github.com/MichelliBrito).

## Resultados
Os resultados foram positivos, condizentes com aquilo que era esperado tendo em vista o tutorial utilizado como base de estudos. 
### Questionário do dia 09/12/21  
As configurações iniciais do projeto foram feitas e concluídas com sucesso, permitindo a criação da tabela associada à prática em um banco de dados MySQL.    
![image](https://user-images.githubusercontent.com/51242342/146487219-f267ecde-0628-4bc4-9546-e7ecafb0c31f.png)

### Questionário do dia 16/12/21  
### Persistência no Banco de Dados
Dando continuidade ao projeto em desenvolvimento, inicialmente é feita a configuração para a persistência de dados no banco previamente criado, usando uma interface a qual extendia a classe "CrudRepository", da qual se utilizou o método "save". O armazenamento dos dados de um evento de teste ocorreu corretamente, conforme exposto na figura a seguir. ![image](https://user-images.githubusercontent.com/51242342/148601137-bffee10f-0547-4ca0-975f-a6ee657d73e8.png)

### Busca e Exibição de dados do Banco  
Em sequência, é feita uma busca no banco de dados também utilizando métodos da interface que estende CrudRepository, de modo a recolher todos os eventos salvos no banco de dados e realizar sua listagem. Para tanto, cria-se na view 'index.html' a extrutura necessária para a passagem dos parâmetros dos eventos e sua exibição. Na classe "EventoController", cria-se uma função "listarEventos" a qual utilizando do método findAll() armazena um array de eventos cadastrados. Esse iterable é passado para a view mencionada usando de uma instância da classe "ModelAndView". Os resultados foram satisfatórios, atendendo às expectativas, conforme ilustrado abaixo.  
![image](https://user-images.githubusercontent.com/51242342/148605717-af862767-7b71-40e0-b57f-0cec9ae2ea8d.png)

### Ajustes com Materialize CSS
Como última atividade realizada neste questionário, tem-se o ajuste das páginas HTML em Templates para que as mesmas possuam um layout mais agradável. O processo é feito com o acréscimo do diretório "Materialize" no diretório "Static" em resources, tal como a adaptação dos arquivos para se ajustarem ao framework. O resultado é exibido abaixo. 
![image](https://user-images.githubusercontent.com/51242342/148611174-5bc4c475-9480-4f74-b709-5434e0b6277c.png)

### Questionário do dia 06/01/22  
### Ajustes com Materialize CSS - Contêiners  
De modo a tornar o CSS das páginas anteriormente desenvolvidas ainda mais harmônico, são utilizadas classes já prontas do Materialize CSS as quais delimitam contêiners dentro dos quais as tabelas e formulários já apresentados foram inseridos para não ficarem tão próximos às margens das páginas. O resultado é apresentado em sequência. 
![image](https://user-images.githubusercontent.com/51242342/150659934-7253d302-06bf-4bd5-ae7f-1e060e512e7e.png)

### Criando Links Para a Página de Cada Evento
No sistema em desenvolvimento, é importante ter acesso à página individual de cada evento, a qual conterá detalhes do mesmo, além de uma lista com os seus convidados. De modo a criar e acessar tais páginas de maneira automatizada e efetiva são feitas requisições no EventoController usando uma variável do tipo @PathVariable. Utiliza-se também de urls mvc automatizadas associadas à função implementada no Controller mencionado. O resultado é exposto nas figuras adiante. 
![image](https://user-images.githubusercontent.com/51242342/150660003-8fbb1b51-9fab-4ced-af07-2f7301964953.png)
![image](https://user-images.githubusercontent.com/51242342/150660011-31ce5cc1-8d3c-41fb-9e38-2b0649b0591d.png)

### Criando a Entidade Convidado e a Relacionando com Evento
Conforme mencionado no item anterior, os eventos cadastrados no sistema devem possuir uma lista de convidados. Esta deve conter instâncias de convidados, cada qual com nome e RG. De modo a representar estes indivíduos no código, é criada a classe Convidado, a qual tem a notação @Entity de modo a ser identificada como uma tabela no banco de dados, sendo o RG a chave primária (ID) da mesma. De modo a associar a entidade em questão com a entidade evento, são criadas dois objetos, um na classe Convidado, do tipo evento, o qual é identificado com a notação @ManyToOne, e outro na classe Evento, que corresponde a uma lista do tipo convidado a qual é classificada como @OneToMany. A primeira notação identifica que existem vários convidados associados à um só evento, ao passo que a segunda demonstra que existe um evento com muitos convidados. A tabela criada é apresentada abaixo.
![image](https://user-images.githubusercontent.com/51242342/150660152-36bc061d-e048-4948-9d2b-1d3d01320611.png)

Com a tabela e os relacionamentos devidamente estruturados, é criado um formulário para o recebimento dos dados de RG e Nome dos convidados na página do evento, conforme mostrado pela figura. 
![image](https://user-images.githubusercontent.com/51242342/150660144-5732746a-570e-47bc-83dc-3ccd2622793d.png)

### Questionário 13/01/2022
### Inserção dos Convidados no BD
Uma vez criado o formulário de inserção de convidados no Banco de Dados, sua inserção propriamente dita pode ser feita utilizando uma instância de uma interface que extende a classe CrudRepository, de maneira bastante similar ao que foi feito durante o cadastramento de eventos. A interface criada é a ConvidadoRepository, a qual tem a instância cr no EventoaController. Cria-se uma requisição associada ao código do evento e o convidado, passados por post. Através do código, utiliza-se a função findByCodigo para encontrar o evento desejado. Através da função setEvento(), o evento em questão é vinculado ao convidado recebido por parâmetro. Por fim, usa-se a instância cr para efetivar o salvamento no banco. O resultado é exposto em sequência. 
![image](https://user-images.githubusercontent.com/51242342/150660705-a08ee27c-23cf-43b9-b016-0014ee0a3e03.png)


## Conexão Com BD - Observação Útil à prática do dia 09/12
A conexão com o banco de dados pode ser passar por problemas devido ao período de tempo passado após o lançamento do vídeo, logo, podem ser implementadas as soluções descritas nos comentários abaixo.  
![image](https://user-images.githubusercontent.com/51242342/146487290-320f8064-62d1-4713-8199-617ec1923a27.png)  
![image](https://user-images.githubusercontent.com/51242342/146487391-0fb00692-356d-47b6-8470-a0a3bd002e1c.png)  
