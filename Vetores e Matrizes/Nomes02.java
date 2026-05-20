void main (){
    var nome = new String [5];
    String aux;

    for (int cont=0;cont<nome.length;cont++)
        nome[cont] = IO.readln("Digite o nome [" + cont + "]: " );

    IO.println("Estes foram os nomes digitados: ");
    for (int cont=0;cont<nome.length;cont++)
        IO.println("Nome[" + (cont) + "]: " + nome[cont]);
    //ROTINA DE ORDENAÇÃO
    for (int i=0;i<nome.length-1;i++)
        if (nome[i] . compareToIgnoreCase(nome[j]) > 0){
            aux = nome [i];
            nome [i] = nome [j]
            nome [j] =aux;
        }
        IO.print
}