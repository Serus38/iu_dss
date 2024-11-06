package com.mycompany.iu_dss.dao;

import com.mycompany.iu_dss.domain.Funcionario;
import com.mycompany.iu_dss.util.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDao {
    
    private static final String GET_FUNCIONARIOS =  "select * from funcionarios";
    
    private static final String CRETAE_FUNCIONARIO = "insert into funcionarios (tipo_identificacion,"
            + " numero_identificacion, nombre, apellido, estado_civil, sexo, direccion, telefono, fecha_nacimiento)"
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
    private static final String GET_FUNCIONARIO_BY_ID = "select * from funcionarios where id_funcionarios = ?";
    
    private static final String UPDATE_FUNCIONARIO = "update funcionarios set tipo_identificacion = ?, numero_identificacion = ?, nombre = ?"
            + "apellido = ?, estado_civil = ?, sexo = ?, direccion = ?, telefono = ?, fecha_nacimiento = ?"
            + "where id_funcionarios = ?";
    
    private static final String DELETE_FUNCIONARIO = "delete from funcionarios where id_funcionarios = ?";
    
    public List<Funcionario> getAllFuncionarios() throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        
        try {
            
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIOS);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
            
                Funcionario funcionario = new Funcionario();
                funcionario.setFuncionarioId(resultSet.getInt("id_funcionarios"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNumeroIdentificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setEstadoCivil(resultSet.getString("estado_civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fecha_nacimiento"));
                funcionarios.add(funcionario);
            }
            return funcionarios;
            
        } finally {
            
            if (connection != null){
                connection.close();
            }
            
            if (preparedStatement != null){
                preparedStatement.close();
            }
            
            if (resultSet != null){
                resultSet.close();
            }
        }
        
        
    }
    
    public void createFuncionario (Funcionario funcionario) throws SQLException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {
            
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CRETAE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getTipoIdentificacion());
            preparedStatement.setString(2, funcionario.getNumeroIdentificacion());
            preparedStatement.setString(3, funcionario.getNombre());
            preparedStatement.setString(4, funcionario.getApellido());
            preparedStatement.setString(5, funcionario.getEstadoCivil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFechaNacimiento());
            preparedStatement.executeUpdate();
            
        
            
            } finally {
            
            if (connection != null){
                connection.close();
            }
            
            if (preparedStatement != null){
                preparedStatement.close();  
            }    
        }    
    }
    
    public Funcionario getOneFuncionario (int funcionarioId) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Funcionario funcionario = null;
        
        try {
            
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_FUNCIONARIO_BY_ID);
            preparedStatement.setInt(1, funcionarioId);
            resultSet = preparedStatement.executeQuery();
            
            if (resultSet.next()){
                funcionario = new Funcionario();
                funcionario.setFuncionarioId(resultSet.getInt("id_funcionarios0"));
                funcionario.setTipoIdentificacion(resultSet.getString("tipo_identificacion"));
                funcionario.setNumeroIdentificacion(resultSet.getString("numero_identificacion"));
                funcionario.setNombre(resultSet.getString("nombre"));
                funcionario.setApellido(resultSet.getString("apellido"));
                funcionario.setEstadoCivil(resultSet.getString("estado_civil"));
                funcionario.setSexo(resultSet.getString("sexo"));
                funcionario.setDireccion(resultSet.getString("direccion"));
                funcionario.setTelefono(resultSet.getString("telefono"));
                funcionario.setFechaNacimiento(resultSet.getString("fecha_nacimiento"));
            }
            return funcionario;
            
        }finally{
            
            if (connection != null){
                connection.close();
            }
            
            if (preparedStatement != null){
                preparedStatement.close();  
            }
            
            if (resultSet != null){
                resultSet.close();
            }
        }
        
    }
    
    public void updateFuncionario(Funcionario funcionario, int funcionarioId) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {

            connection = ConnectionUtil.getConnection();                
            preparedStatement = connection.prepareStatement(UPDATE_FUNCIONARIO);
            preparedStatement.setString(1, funcionario.getTipoIdentificacion());
            preparedStatement.setString(2, funcionario.getNumeroIdentificacion());
            preparedStatement.setString(3, funcionario.getNombre());
            preparedStatement.setString(4, funcionario.getApellido());
            preparedStatement.setString(5, funcionario.getEstadoCivil());
            preparedStatement.setString(6, funcionario.getSexo());
            preparedStatement.setString(7, funcionario.getDireccion());
            preparedStatement.setString(8, funcionario.getTelefono());
            preparedStatement.setString(9, funcionario.getFechaNacimiento());
            preparedStatement.setInt(10, funcionarioId);
            preparedStatement.executeUpdate();

        } finally {

            if (connection != null){
                connection.close();
            }

            if (preparedStatement != null){
                preparedStatement.close();  
            }
        }
    }
    
    public void deleteFuncionario (int funcionarioId) throws SQLException{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        try {

            connection = ConnectionUtil.getConnection();                
            preparedStatement = connection.prepareStatement(DELETE_FUNCIONARIO);
            preparedStatement.setInt(1, funcionarioId);
            preparedStatement.executeUpdate();

        } finally {

            if (connection != null){
                connection.close();
            }

            if (preparedStatement != null){
                preparedStatement.close();  
            }
        }
    }

}
    
    


