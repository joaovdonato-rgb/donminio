void main() {
    int numero = Integer.parseInt(IO.readln("Informe um número: "));
    int multiplicador = 1;

    do { 
        System.out.printf("%d x %d = %d \n", numero, multiplicador, numero*multiplicador);
        multiplicador++;
    } while (multiplicador<=10);
}