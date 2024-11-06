package com.mycompany.iu_dss.controller;

import com.mycompany.iu_dss.dao.FuncionarioDao;
import com.mycompany.iu_dss.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;

public class FuncionarioController {
    
    private FuncionarioDao funcionarioDao;
    
    public FuncionarioController() {
        funcionarioDao = new FuncionarioDao();
    }
    
    public List<Funcionario> getFuncionarios() throws SQLException {
        return funcionarioDao.getAllFuncionarios();
    }
    
    public void createOneFuncionario(Funcionario funcionario) throws SQLException{
        funcionarioDao.createFuncionario(funcionario);
    }
    
    public Funcionario getFuncionario (int funcionarioId) throws SQLException {
        return funcionarioDao.getOneFuncionario(funcionarioId);
    }
    
    public void update(Funcionario funcionario, int funcionarioId) throws SQLException{
        funcionarioDao.updateFuncionario(funcionario, funcionarioId);
        
    }
    
    public void delete (int funcionarioId) throws SQLException{
        funcionarioDao.deleteFuncionario(funcionarioId);
    }
}
