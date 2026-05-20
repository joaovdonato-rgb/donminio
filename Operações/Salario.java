void main() {

    // como faziam os incas, astecas e os maias

    float salario, percentual, novoSalario;

    salario = Float.parseFloat(IO.readln("Informe o seu salário: "));
    percentual = Float.parseFloat(IO.readln("Informe o percentual de aumento: "));

    novoSalario = salario * (1 + percentual/100);

    IO.println("O salário de " + salario + " com " + percentual + "% de aumento é:" + novoSalario);
    

}