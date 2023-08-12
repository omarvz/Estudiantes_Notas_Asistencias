package com.appress.gestionacademica.service;

import com.appress.gestionacademica.model.Cuenta;

import java.util.ArrayList;
import java.util.Optional;

public interface CuentaService {
    ArrayList<Cuenta> getAllAccount();
    Optional<Cuenta> getAccountById(long id);
    Cuenta saveAccount(Cuenta cuenta);
    boolean deleteAccountById(long id);
}
