void main(){
    int tam=8;
    var a = new int [tam];
    var b = new int [tam];

    IO.println("Vetor A: ");
    for (int cont=0;cont<tam;cont++){
        a[cont] = Integer.parseInt(IO.readln("A[" + cont + "]: "));
        b[cont] = a[cont] * 3;
    }
    IO.println("Vetor B: ");
    for (int cont=0;cont<tam; cont ++)
        IO.println("B[" + (cont) + "]: "+ b[cont]);
}