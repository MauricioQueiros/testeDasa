#language:pt
#Author: Mauricio Barbosa de Queiros Junior
#Version: 1.0

@Web
Funcionalidade: Testes de Validação do sistema To-do.

  Contexto:
    Dado que esteja no site
      | Site  |
      | to-do |

  @Cadastro_tarefa
  Cenario: Cadastrar uma tarefa
    Quando cadastrar uma tarefa
    Entao sera cadastrada uma nova tarefa

  @Cadastro_tarefa_multiplo
  Cenario: Cadastrar multiplas tarefas
    Quando cadastrar multiplas tarefas
    Entao seram cadastradas multiplas tarefas

  @Conclusao_tarefa
  Cenario: Conclusao de uma tarefa
    Quando cadastrar uma tarefa
    E conclui-la
    Entao ela aparecera como DONE

  @Excluir_Tarefa
  Cenario: Excluir tarefa em ToDo
    Quando cadastrar uma tarefa
    E exclui-la
    Entao ela nao aparecera mais na listagem