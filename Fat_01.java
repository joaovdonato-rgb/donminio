void main (){

    float fatorial = 1;

    int numero = Integer.parseInt(IO.readln("Digite um número: "));

    for( int contador = 1; contador <= numero; contador++)
        fatorial = fatorial * contador;

    System.out.println("O fatorial de " + numero + " é:  "+ fatorial);

}