
void main(){ 

    var num = new int[10];
    int pesq, aux, ini, fim, meio=0;
    boolean achou;
    for (int cont=0;cont<num.length;cont++)
        num[cont] = Integer.parseInt(IO.readln("Digite o " + (cont+1) + "o numero: "));
    for (int i=0;i<num.length-1;i++)
        for (int j=i+1;j<num.length;j++)
            if (num[i] > num[j]){
                aux = num[i];
                num[i]=num[j];
                num[j]=aux;
                }
    char resp = IO.readln("Deseja pesquisar (S/N)?: ").toUpperCase().charAt(0);
    while (resp=='S'){
        pesq = Integer.parseInt(IO.readln("Digite o número procurado: ")); 
        ini = 0;
        fim = num.length;
        achou = false;
        while (ini<=fim && !achou){
            meio = (ini+fim)/2;
            if (num[meio]==pesq)
                achou=true;
            else
                if (pesq < num[meio])
                    fim = meio-1;
                else
                    ini = meio+1;
        }
        if (achou)
            IO.println(pesq + " encontrado na " + (meio+1) + "a posição" );
        else
            IO.println(pesq + " não foi encontrado");
        resp =  IO.readln("Deseja continuar a pesquisa (S/N)?: ").toUpperCase().charAt(0);          
    }
}