# Spring-Boot-LPII
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


## Conexão Com BD - Observação Útil à prática do dia 09/12
A conexão com o banco de dados pode ser passar por problemas devido ao período de tempo passado após o lançamento do vídeo, logo, podem ser implementadas as soluções descritas nos comentários abaixo.  
![image](https://user-images.githubusercontent.com/51242342/146487290-320f8064-62d1-4713-8199-617ec1923a27.png)  
![image](https://user-images.githubusercontent.com/51242342/146487391-0fb00692-356d-47b6-8470-a0a3bd002e1c.png)  
