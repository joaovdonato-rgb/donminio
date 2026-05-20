void main() {

    double capital = Double.parseDouble(IO.readln("Digite o capital inicial (R$): "));
    double taxaPercentual = Double.parseDouble(IO.readln("Digite a taxa de juros mensal (%): "));
    int tempo = Integer.parseInt(IO.readln("Digite o tempo (em meses): "));

    
    double taxaDecimal = taxaPercentual / 100.0;

 
    double montante = capital * Math.pow(1 + taxaDecimal, tempo);
    double jurosPretendidos = montante - capital;

   
    IO.println("RESULTADO");
    IO.println("Total de Juros acumulados: R$ " + jurosPretendidos);
    IO.println("Montante final (Capital + Juros): R$ " + montante);
}