
package com.mycompany.iu_dss.presentacion;

import com.mycompany.iu_dss.controller.FuncionarioController;
import com.mycompany.iu_dss.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Iu_dss {
    
    public static void getFuncionarioList(FuncionarioController funcionarioController) {
        try {
            List<Funcionario> funcionarios = funcionarioController.getFuncionarios();
            if (funcionarios.isEmpty()){
                System.out.println("No hay dsatos");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("Id:" + funcionario.getFuncionarioId());
                    System.out.println("Tipo de identificacion:" + funcionario.getTipoIdentificacion());
                    System.out.println("Numero identificacion:" + funcionario.getNumeroIdentificacion());
                    System.out.println("Nombre:" + funcionario.getNombre());
                    System.out.println("Apellido:" + funcionario.getApellido());
                    System.out.println("Estado civil:" + funcionario.getEstadoCivil());
                    System.out.println("Sexo:" + funcionario.getSexo());
                    System.out.println("Direccion:" + funcionario.getDireccion());
                    System.out.println("Telefono:" + funcionario.getTelefono());
                    System.out.println("Fecha nacimiento:" + funcionario.getFechaNacimiento());
                    System.out.println("=====================================================");
                    System.out.println("=====================================================");
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void crear(FuncionarioController funcionarioController){
        try {


            Scanner sc = new Scanner (System.in);

            System.out.println("Digite el tipo de identificacion: ");
            String tipoIdentificacion = sc.nextLine();
            System.out.println("El tipo de identificacion es: " + tipoIdentificacion);
            System.out.println("--------------------------------------------------");

            System.out.println("Digite el numero de identificacion: ");
            String numeroIdentificacion = sc.nextLine();
            System.out.println("El numero de identificacion es: " + tipoIdentificacion);
            System.out.println("--------------------------------------------------");

            System.out.println("Digite el nombre: ");
            String nombre = sc.nextLine();
            System.out.println("El nombre es: " + nombre);
            System.out.println("--------------------------------------------------");

            System.out.println("Digite el apellido: ");
            String apellido = sc.nextLine();
            System.out.println("El apellido es: " + apellido);
            System.out.println("--------------------------------------------------");

            System.out.println("Digite el estado civil: ");
            String estadoCivil = sc.nextLine();
            System.out.println("El estado civil es: " + estadoCivil);
            System.out.println("--------------------------------------------------");

            System.out.println("Digite el sexo: ");
            String sexo = sc.nextLine();
            System.out.println("El sexo es: " + sexo);
            System.out.println("--------------------------------------------------");

            System.out.println("Digite la direccion: ");
            String direccion = sc.nextLine();
            System.out.println("La direccion es: " + direccion);
            System.out.println("--------------------------------------------------");

            System.out.println("Digite el telefono: ");
            String telefono = sc.nextLine();
            System.out.println("El telefono es: " + telefono);
            System.out.println("--------------------------------------------------");

            System.out.println("Digite la fecha de nacimiento: ");
            String fechaNacimiento = sc.nextLine();
            System.out.println("La fecha de nacimiento es: " + fechaNacimiento);
            System.out.println("--------------------------------------------------");

            Funcionario funcionario = new Funcionario();
            funcionario.setTipoIdentificacion(tipoIdentificacion);
            funcionario.setNumeroIdentificacion(numeroIdentificacion);
            funcionario.setNombre(nombre);
            funcionario.setApellido(apellido);
            funcionario.setEstadoCivil(estadoCivil);
            funcionario.setSexo(sexo);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFechaNacimiento(fechaNacimiento);
        
            funcionarioController.createOneFuncionario(funcionario);
            getFuncionarioList(funcionarioController);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("El funcionario fue creado exitosamente ");
    }

    public static void main(String[] args) {
        FuncionarioController funcionarioController = new FuncionarioController();
        //getFuncionarioList(funcionarioController);
        crear (funcionarioController);
    }
}
