void main (){ 
    var num = new int [5];

    for (int cont=0;cont<5;cont++)
        num[cont]= Integer.parseInt(IO.readln("Digite o " + (cont+1) + " o numero: "));

    IO.println("Estes foram os números digitados: ");
    for (int cont=0;cont<5;cont++)
        IO.println("Posição " + (cont) + " numero: " + num[cont]);
}