import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorTarefas {
    private List<String> tarefas;
    private List<String> horarios;

    public GerenciadorTarefas() {
        tarefas = new ArrayList<>();
        horarios = new ArrayList<>();
    }

    public void adicionarTarefa(String tarefa, String horario) {
        tarefas.add(tarefa);
        horarios.add(horario);
        JOptionPane.showMessageDialog(null, "Tarefa adicionada: " + tarefa + " (" + horario + ")");
    }

    public void removerTarefa(int indice) {
        if (indice >= 0 && indice < tarefas.size()) {
            String tarefaRemovida = tarefas.remove(indice);
            String horarioRemovido = horarios.remove(indice);
            JOptionPane.showMessageDialog(null, "Tarefa removida: " + tarefaRemovida + " (" + horarioRemovido + ")");
        } else {
            JOptionPane.showMessageDialog(null, "�ndice inv�lido!");
        }
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma tarefa encontrada.");
        } else {
            StringBuilder lista = new StringBuilder("Lista de Tarefas:\n");
            for (int i = 0; i < tarefas.size(); i++) {
                lista.append(i).append(". ").append(tarefas.get(i)).append(" (").append(horarios.get(i)).append(")\n");
            }
            JOptionPane.showMessageDialog(null, lista.toString());
        }
    }

    public static void main(String[] args) {
        GerenciadorTarefas gerenciador = new GerenciadorTarefas();

        while (true) {
            String opcaoStr = JOptionPane.showInputDialog(
                    "Op��es:\n" +
                            "1. Adicionar tarefa\n" +
                            "2. Remover tarefa\n" +
                            "3. Listar tarefas\n" +
                            "4. Sair\n\n" +
                            "Escolha uma op��o:"
            );

            if (opcaoStr == null) {
                break; // O usu�rio fechou a janela
            }

            try {
                int opcao = Integer.parseInt(opcaoStr);
                switch (opcao) {
                    case 1:
                        String tarefa = JOptionPane.showInputDialog("Digite a tarefa:");
                        String horario = JOptionPane.showInputDialog("Digite o hor�rio da tarefa:");
                        if (tarefa != null && !tarefa.isEmpty() && horario != null && !horario.isEmpty()) {
                            gerenciador.adicionarTarefa(tarefa, horario);
                        } else {
                            JOptionPane.showMessageDialog(null, "Tarefa ou hor�rio inv�lido!");
                        }
                        break;
                    case 2:
                        String indiceStr = JOptionPane.showInputDialog("Digite o �ndice da tarefa a ser removida:");
                        if (indiceStr != null && !indiceStr.isEmpty()) {
                            int indice = Integer.parseInt(indiceStr);
                            gerenciador.removerTarefa(indice);
                        } else {
                            JOptionPane.showMessageDialog(null, "�ndice inv�lido!");
                        }
                        break;
                    case 3:
                        gerenciador.listarTarefas();
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Saindo do gerenciador de tarefas...");
                        System.exit(0);
                    default:
                        JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Op��o inv�lida!");
            }
        }
    }
}


