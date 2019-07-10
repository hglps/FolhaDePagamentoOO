# FolhaPagamentoOO

Projeto OO - Folha de Pagamento

Início: usando senha **"admin"** que pode ser alterada posteriormente.

FORMATO DE ID: 190021xx@yyy (x = int, y= String, ID completo = String), com limite de 500 funcionários. Pode ser alterado na constante "maxSize" e pela estrutura de dados dinâmica.

Após, terá as opções:

'-1' - Sair do sistema

1-Adicionar um funcionário - Formatos de entrada explicitados quando solicitadas as entradas.

2-Deletar um funcionário - Entra com um ID e deleta as informações do requerido funcionário.

3-Bater cartão de ponto. Entra com um ID e altera diretamente, entrando para evidenciar horário de entrada ou saída válido, executando o cálculo de horas trabalhadas.

4-Inserir resultados de vendas- Válido apenas para funcionários comissionados. Entra com um ID válido e o valor numérico positivo da venda naquele dia, executando o cálculo da comissão equivalente.

5-Inserir taxas de serviço - Válido apenas para membros de um sindicato. Insere um ID válido e um valor numérico positivo da taxa de serviço.

6-Mudar registro de um funcionário - Insere um ID válido e altera quantas informações desejar.

7-Executar Undo ou Redo. (Utilização de pilhas Undo e Redo)


8-Rodar folha de pagamento - Paga todos os funcionários que recebem naquele dia. Nota-se que ao executar tal função, será passado um dia. Ele paga os funcionários que tiverem trabalhado pelo menos o tempo mínimo estimado para o tipo do funcionário.

9-Escolher uma agenda de pagamento para um funcionário.

**Note-se que comissionados só podem receber de 2 em 2 semanas, horistas apenas semanalmente e assalariados apenas mensalmente.**

**Salariados escolhem um dia de pagamento ou o último dia útil do mês.**

**Comissionados e horistas escolhem apenas o dia da semana que preferem ser pagos.**

10-Criar novas agendas de pagamento

**FORMATO:( - - - - - - )ou (p, ,int,int, , d)**

**onde, p = forma de pagamento ( 'm'- mensal ou 's' - semanal) // int int = '01' ou '02' (se for semanal -- 01 ou 02 semanas) ou '00' até '25' ( dia de pagamento) se for pago mensalmente // d = se for semanalmente pago, será um int de 0 a 6, indicando o dia da semana ( 0- Segunda, 1 - Terça, ..., 6 - Domingo)**

11-Mostrar informações de 1 funcionário ou de todos cadastrados

12-Mudar senha do sistema - Inserindo a senha atual, pode-se mudá-la.

13-Zerar pilha de estados. (Debug)

Arquivos finais = pacotes em FolhaDePagamentoOO/src

Info: **hlc2@ic.ufal.br**
