void main() {

    String[] nomes = new String[20];
    double[] medias = new double[20];
    int total = 0;
    int op;

    do {
        IO.println("\n=== MENU PRINCIPAL: GESTÃO DE TURMA ===");
        IO.println("1 - Cadastrar Alunos e Médias");
        IO.println("2 - Exibir Lista de Alunos e Notas");
        IO.println("3 - Buscar Aluno");
        IO.println("4 - Sair");
        op = Integer.parseInt(IO.readln("Escolha uma opção: "));

        if (op == 1) {
            total = cadastrarAlunos(nomes, medias, total);

        } else if (op == 2) {
            listarAlunos(nomes, medias, total);

        } else if (op == 3) {
            if (total == 0) {
                IO.println("Nenhum aluno cadastrado.");
            } else {
                ordenar(nomes, medias, total);
                String busca = IO.readln("Nome do aluno: ");
                int pos = pesquisarAluno(busca, nomes, total);
                if (pos == -1) {
                    IO.println("Aluno não encontrado.");
                } else {
                    String sit = medias[pos] >= 7.0 ? "Aprovado" : "Reprovado";
                    IO.println("Nome: " + nomes[pos]);
                    IO.println("Média: " + medias[pos]);
                    IO.println("Situação: " + sit);
                }
            }

        } else if (op != 4) {
            IO.println("Opção inválida.");
        }

    } while (op != 4);

    IO.println("Encerrando...");
}

int cadastrarAlunos(String[] nomes, double[] medias, int total) {

    if (total == 20) {
        IO.println("Turma cheia!");
        return total;
    }

    int qtd = Integer.parseInt(IO.readln("Quantos alunos? "));

    for (int i = 0; i < qtd; i++) {

        if (total == 20) {
            IO.println("Limite atingido.");
            break;
        }

        String nome;
        do {
            nome = IO.readln("Nome: ");
            if (jaExiste(nome, nomes, total)) {
                IO.println("Nome repetido, tente outro.");
            }
        } while (jaExiste(nome, nomes, total));

        double media;
        do {
            media = Double.parseDouble(IO.readln("Média de " + nome + ": "));
            if (media < 0.0 || media > 10.0) {
                IO.println("Média inválida! Digite entre 0.0 e 10.0.");
            }
        } while (media < 0.0 || media > 10.0);

        nomes[total] = nome;
        medias[total] = media;
        total++;
    }

    return total;
}

boolean jaExiste(String nome, String[] nomes, int total) {
    for (int i = 0; i < total; i++) {
        if (nomes[i].equalsIgnoreCase(nome)) {
            return true;
        }
    }
    return false;
}

void listarAlunos(String[] nomes, double[] medias, int total) {

    if (total == 0) {
        IO.println("Lista vazia.");
        return;
    }

    IO.println("\n--- Lista de Alunos ---");
    for (int i = 0; i < total; i++) {
        String sit = medias[i] >= 7.0 ? "Aprovado" : "Reprovado";
        IO.println(nomes[i] + " - " + medias[i] + " - " + sit);
    }
    IO.println("Total: " + total + " aluno(s).");
}

int pesquisarAluno(String nome, String[] nomes, int total) {
    int ini = 0;
    int fim = total - 1;

    while (ini <= fim) {
        int meio = (ini + fim) / 2;
        int cmp = nomes[meio].compareToIgnoreCase(nome);

        if (cmp == 0) {
            return meio;
        } else if (cmp < 0) {
            ini = meio + 1;
        } else {
            fim = meio - 1;
        }
    }
    return -1;
}

void ordenar(String[] nomes, double[] medias, int total) {
    for (int i = 0; i < total - 1; i++) {
        for (int j = 0; j < total - 1 - i; j++) {
            if (nomes[j].compareToIgnoreCase(nomes[j + 1]) > 0) {
                String tn = nomes[j];
                nomes[j] = nomes[j + 1];
                nomes[j + 1] = tn;

                double tm = medias[j];
                medias[j] = medias[j + 1];
                medias[j + 1] = tm;
            }
        }
    }
}