package com.appress.gestionacademica.service;

import com.appress.gestionacademica.Repository.CuentaRepository;
import com.appress.gestionacademica.model.Cuenta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class CuentaServiceImpl implements CuentaService{

    @Autowired
    CuentaRepository cuentaRepository;
    @Override
    public ArrayList<Cuenta> getAllAccount() {
        return (ArrayList<Cuenta>) cuentaRepository.findAll();
    }

    @Override
    public Optional<Cuenta> getAccountById(long id) {
        return cuentaRepository.findById(id);
    }

    @Override
    public Cuenta saveAccount(Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @Override
    public boolean deleteAccountById(long id) {
        try{
            Optional<Cuenta> optionalCuenta = cuentaRepository.findById(id);
            if(optionalCuenta.isPresent()){
                Cuenta cuenta = optionalCuenta.get();
                cuenta.setActivo(false);
                cuentaRepository.save(cuenta);
                return true;
            }
            return false;
        }catch (Exception e){
            return  false;
        }
    }
}
