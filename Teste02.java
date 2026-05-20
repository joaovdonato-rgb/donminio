void main(){

    float salario, aumento, novoSalario;

     salario = Float.parseFloat(IO.readln("Digite o salário: "));
     aumento = Float.parseFloat(IO.readln("Digite o aumento: "));

    novoSalario = salario * ( 1 + aumento / 100);

    IO.println("O novo salário é: " + novoSalario);
}