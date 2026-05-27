void main(){
    
    var num = new int[5];
    int cont;
    boolean achou;

    for (cont=0; cont<num.length; cont++)
        num[cont] = Integer.parseInt(IO.readln("Digite o " + (cont+1) + " o numero: "));

    char resp = IO.readln("Deseja pesquisar (S/N)?: ").toUpperCase().charAt(0);
    int pesq; 
    while (resp == 'S'){
        pesq = Integer.parseInt(IO.readln("Digite o número procurado: ")); 
        cont = 0;
        achou = false;
        while (!achou && cont<num.length){
            if (num[cont]==pesq)
                achou=true;
            else
                cont++;
        }
        if (achou)
            IO.println(pesq + " encontrado na " + (cont+1) + " a posição" );
        else
            IO.println(pesq + " não foi encontrado");
        resp =  IO.readln("Deseja continuar a pesquisa (S/N)?: ").toUpperCase().charAt(0);
    }
    
}  