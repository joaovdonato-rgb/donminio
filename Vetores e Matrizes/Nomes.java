void main (){
    String a = IO.readln("Digite um nome: ");
    String b = IO.readln("Digite outro nome: ");
    if (a.compareToIgnoreCase(b)<0)
        IO.println("O nome " + a + " vem antes do nome "  + b + " na ordem alfabética");
    else 
        IO.println("O nome " + b + " vem antes do nome"  + a + " na ordem alfabética");
}