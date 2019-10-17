/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoCidade;
import javax.swing.JOptionPane;
import modelo.cidade;
import tela.manutencao.ManutencaoCidade;
import tela.manutencao.ManutencaoCidade;
import java.time.LocalDate; 
import java.time.format.DateTimeFormatter;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrador
 */
public class ControladorCidade {

    public static void inserir(ManutencaoCidade man){
        cidade objeto = new cidade();
        objeto.setSigla(man.jtfSigla.getText());
        objeto.setNome(man.jtfNome.getText());
        objeto.setNr_habitantes(Integer.parseInt(man.jtfNr_habitantes.getText()));
        objeto.setArea_total(Double.parseDouble(man.jtfArea_total.getText()));
        objeto.setDistancia_capital(Integer.parseInt(man.jtfDistancia_capital.getText()));
        objeto.setData_emacipacao(LocalDate.parse(man.jtfData_emancipacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        boolean resultado = DaoCidade.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção

        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}
    
    public static void alterar(ManutencaoCidade man){
        cidade objeto = new cidade();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setSigla(man.jtfSigla.getText());
        objeto.setNome(man.jtfNome.getText());
        objeto.setNr_habitantes(Integer.parseInt(man.jtfNr_habitantes.getText()));
        objeto.setArea_total(Double.parseDouble(man.jtfArea_total.getText()));
        objeto.setDistancia_capital(Integer.parseInt(man.jtfDistancia_capital.getText()));
        objeto.setData_emacipacao(LocalDate.parse(man.jtfData_emancipacao.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        
        
        boolean resultado = DaoCidade.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção

        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
    public static void excluir(ManutencaoCidade man){
        cidade objeto = new cidade();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoCidade.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
            if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção

        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Sigla do estado");
        modelo.addColumn("Número de habitantes");
        modelo.addColumn("Data de emancipação");
        modelo.addColumn("Área total");
        modelo.addColumn("Distância da capital");
        List<cidade> resultados = DaoCidade.consultar();
        for (cidade objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome());
            linha.add(objeto.getSigla());
            linha.add(objeto.getNr_habitantes());
            linha.add(objeto.getData_emacipacao());
            linha.add(objeto.getArea_total());
            linha.add(objeto.getDistancia_capital());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
 public static void atualizaCampos(ManutencaoCidade man, int pk){ 
        cidade objeto = DaoCidade.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
        man.jtfNome.setText(objeto.getNome());
        man.jtfSigla.setText(objeto.getSigla());
        man.jtfNr_habitantes.setText(objeto.getNr_habitantes().toString());
        man.jtfDistancia_capital.setText(objeto.getDistancia_capital().toString());
        man.jtfData_emancipacao.setText(objeto.getData_emacipacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        man.jtfArea_total.setText(objeto.getArea_total().toString());
        
        man.jtfCodigo.setEnabled(false); //desabilitando o campo código
        man.btnAdiconar.setEnabled(false); //desabilitando o botão adicionar
    }
    
}
