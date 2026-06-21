void main() {

    // Vetores paralelos para até 20 alunos
    String[] nomes  = new String[20];
    double[] medias = new double[20];
    int totalAlunos = 0;

    int opcao;

    do {
        IO.println("\n=== MENU PRINCIPAL: GESTÃO DE TURMA ===");
        IO.println("1 - Cadastrar Alunos e Médias");
        IO.println("2 - Exibir Lista de Alunos e Notas");
        IO.println("3 - Buscar Aluno");
        IO.println("4 - Sair");
        opcao = Integer.parseInt(IO.readln("Escolha uma opção: "));

        switch (opcao) {
            case 1 -> totalAlunos = cadastrarAlunos(nomes, medias, totalAlunos);
            case 2 -> listarAlunos(nomes, medias, totalAlunos);
            case 3 -> {
                if (totalAlunos == 0) {
                    IO.println("Nenhum aluno cadastrado ainda.");
                } else {
                    ordenarVetores(nomes, medias, totalAlunos);
                    String nomeBusca = IO.readln("Digite o nome do aluno a buscar: ");
                    int idx = pesquisarAluno(nomeBusca, nomes, totalAlunos);
                    if (idx == -1) {
                        IO.println("Aluno \"" + nomeBusca + "\" não consta na lista.");
                    } else {
                        String situacao = medias[idx] >= 7.0 ? "Aprovado" : "Reprovado";
                        IO.println("\n--- Aluno encontrado ---");
                        IO.println("Nome    : " + nomes[idx]);
                        IO.println("Média   : " + medias[idx]);
                        IO.println("Situação: " + situacao);
                    }
                }
            }
            case 4 -> IO.println("Encerrando o sistema. Até logo!");
            default -> IO.println("Opção inválida! Tente novamente.");
        }

    } while (opcao != 4);
}


int cadastrarAlunos(String[] nomes, double[] medias, int totalAlunos) {

    if (totalAlunos >= 20) {
        IO.println("Turma cheia! Limite de 20 alunos atingido.");
        return totalAlunos;
    }

    int qtd = Integer.parseInt(IO.readln("Quantos alunos deseja cadastrar? "));

    for (int i = 0; i < qtd; i++) {

        if (totalAlunos >= 20) {
            IO.println("Limite de 20 alunos atingido. Cadastro encerrado.");
            break;
        }

        // --- Leitura e validação do nome (sem duplicatas) ---
        String nome;
        boolean duplicado;
        do {
            nome = IO.readln("Nome do aluno " + (totalAlunos + 1) + ": ");
            duplicado = nomeJaCadastrado(nome, nomes, totalAlunos);
            if (duplicado) {
                IO.println("Nome já cadastrado! Informe um nome diferente.");
            }
        } while (duplicado);

        // --- Leitura e validação da média (0.0 a 10.0) ---
        double media;
        do {
            media = Double.parseDouble(IO.readln("Média final de " + nome + " (0.0 a 10.0): "));
            if (media < 0.0 || media > 10.0) {
                IO.println("Média inválida! Deve estar entre 0.0 e 10.0.");
            }
        } while (media < 0.0 || media > 10.0);

        nomes[totalAlunos]  = nome;
        medias[totalAlunos] = media;
        totalAlunos++;
        IO.println("Aluno cadastrado com sucesso!");
    }

    return totalAlunos;
}


boolean nomeJaCadastrado(String nome, String[] nomes, int total) {
    for (int i = 0; i < total; i++) {
        if (nomes[i].equalsIgnoreCase(nome)) {
            return true;
        }
    }
    return false;
}
void listarAlunos(String[] nomes, double[] medias, int totalAlunos) {

    if (totalAlunos == 0) {
        IO.println("Nenhum aluno cadastrado ainda.");
        return;
    }

    IO.println("\n========================================");
    IO.println("       LISTA DE ALUNOS E NOTAS         ");
    IO.println("========================================");

    for (int i = 0; i < totalAlunos; i++) {
        String situacao = medias[i] >= 7.0 ? "Aprovado" : "Reprovado";
        IO.println((i + 1) + ". " + nomes[i] + " | Média: " + medias[i] + " | " + situacao);
    }

    IO.println("========================================");
    IO.println("Total de alunos: " + totalAlunos);
}


int pesquisarAluno(String nomeBusca, String[] nomes, int totalAlunos) {

    int inicio = 0;
    int fim    = totalAlunos - 1;

    while (inicio <= fim) {
        int meio = (inicio + fim) / 2;
        int comparacao = nomes[meio].compareToIgnoreCase(nomeBusca);

        if (comparacao == 0) {
            return meio;       // Encontrado
        } else if (comparacao < 0) {
            inicio = meio + 1; // Buscar na metade direita
        } else {
            fim = meio - 1;    // Buscar na metade esquerda
        }
    }

    return -1; // Não encontrado
}

void ordenarVetores(String[] nomes, double[] medias, int totalAlunos) {

    for (int i = 0; i < totalAlunos - 1; i++) {
        for (int j = 0; j < totalAlunos - 1 - i; j++) {

            if (nomes[j].compareToIgnoreCase(nomes[j + 1]) > 0) {

                // Troca nos nomes
                String tempNome = nomes[j];
                nomes[j]        = nomes[j + 1];
                nomes[j + 1]    = tempNome;

                // Troca REPLICADA nas médias (paralelismo)
                double tempMedia = medias[j];
                medias[j]        = medias[j + 1];
                medias[j + 1]    = tempMedia;
            }
        }
    }
}