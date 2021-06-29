# SaveTheRopa S.A

SaveTheRopa S.A é uma empresa que pretende implementar um sistema informático de guarda-roupa a nível mundial. O sistema permite que uma pessoa guarde seus pertences no guarda-roupa e, em seguida, retirá-los facilmente, bastando apresentar o número identificador que recebe quando são guardados.

Os pertences são representados no sistema por algo abstrato chamado de vestuário, que tem uma marca e um modelo, de forma que se a pessoa perder o número, ela também poderá em algum momento poder reivindicá-lo com aquela informação. No entanto, a reivindicação será modelada em outro momento.

1. Crie a classe Vestuario que contém as variáveis marca e modelo, ambos do tipo String.

2. Crie a classe GuardaRoupa que contém como variável um dicionário e um contador para ser usado como identificador. As chaves do dicionário serão Integer e como valor uma lista de roupas.

3. Crie o método public Integer guardarVestuarios(List<Vestuario> listaDeVestuario), na classe GuardaRoupa, que recebe uma lista de roupas e retorna o número identificador onde as roupas foram atribuídas, ou seja, a chave do dicionário onde guardamos as roupas.

4. Crie o método public void mostrarVestuarios(), na classe GuardaRopa que imprime na tela todas as peças que ficam no guarda-roupa com o número que lhes corresponde.

5. Crie o método public List<Vestuario> devolverVestuarios(Integer id), na classe GuardaRoupa que retorna a lista de roupas armazenadas sob esse número.

6. Criar no método main() um cenário em que alguém guarda duas roupas, recebe o código e, em seguida, retira suas roupas.