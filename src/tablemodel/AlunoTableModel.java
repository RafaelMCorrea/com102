/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Aluno;

/**
 *
 * @author aluno
 */
public class AlunoTableModel extends AbstractTableModel {

    private List<Aluno> alunos;

    public AlunoTableModel() {
        alunos = new ArrayList<Aluno>();
    }

    public AlunoTableModel(List<Aluno> alunos) {
        this();
        this.alunos = alunos;
    }

    @Override
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nome";
            case 1:
                return "Matricula";
            case 2:
                return "Email";
            case 3:
                return "Endereço";
            case 4:
                return "Fone";
            case 5:
                return "Curso";
            default:
                return "";

        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return alunos.get(rowIndex).getNome();
            case 1:
                return alunos.get(rowIndex).getMatricula();
            case 2:
                return alunos.get(rowIndex).getEmail();
            case 3:
                return alunos.get(rowIndex).getEndereco();
            case 4:
                return alunos.get(rowIndex).getFone();
            case 5:
                return alunos.get(rowIndex).getCurso();
            default:
                return "";
                
        }
    }
    
    public Aluno getAluno(int pos){
        if(pos >= alunos.size()){
            return null;
        }
        return alunos.get(pos);
    }

}
