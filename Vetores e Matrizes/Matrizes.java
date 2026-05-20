void main (){
    var a = new int [3][3];

    for (int lin=0;lin<3;lin++)
        for (int col=0;col<3;col++)

            a[lin][col] =Integer.parseInt(IO.readln("Digite A[" + (lin+1) + "][" + (col+1) + "]: "));
    for (int lin=0;lin<3;lin++){
        for (int col=0;col<3;col++)
            System.out.printf("%5d" , a[lin][col]);
        IO.println();
    }
}