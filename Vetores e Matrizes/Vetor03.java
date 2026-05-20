void main (){
    var num = new int[5];
    int aux;

    for (int cont=0;cont<num.length;cont++)
        num[cont] = Integer.parseInt(IO.readln("Digite NUM[" +cont + "]: " ));

    IO.println("Estes foram os números digitados: ");
    for (int cont=0;cont<num.length;cont++)
        IO.println("NUM[" + (cont) + "]: " + num[cont]);
     //ROTINA DE ORDENAÇÃO
     for (int i=0;j<num.length-1;i++)
        for (int j=i+1;j<num.length;j++)
            if (num[i] > num[j]){
                aux = num[i];
                num[i] = num[j];
                num[j] = aux;            
        }
IO.println("Estes foram os números digitados e agora ordenados: ");
for (int cont=0;cont<num.length;cont++)
    IO.println("NUM[" + (cont) + "]: " + num[cont]);
}