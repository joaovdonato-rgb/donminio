void main(){

    int numero = Integer.parseInt(IO.readln("Informe um número: "));

    for (int multiplicador=1; multiplicador<=10; multiplicador++)
        IO.println(numero + " x " + multiplicador + " = " + (numero*multiplicador));
}