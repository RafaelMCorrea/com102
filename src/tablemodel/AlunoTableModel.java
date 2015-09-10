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
public class AlunoTableModel extends AbstractTableModel{

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
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return alunos.get(rowIndex);
    }
    
}
