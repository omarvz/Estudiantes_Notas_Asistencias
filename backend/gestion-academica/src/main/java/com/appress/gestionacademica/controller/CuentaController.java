package com.appress.gestionacademica.controller;

import com.appress.gestionacademica.model.Cuenta;
import com.appress.gestionacademica.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("api/cuentas")
@RestController
public class CuentaController {
    @Autowired
    CuentaService cuentaService;

    @GetMapping("/{id}")
    public Optional<Cuenta> getAccountById(@PathVariable("id") long id){
        return cuentaService.getAccountById(id);
    }

    @PostMapping
    public Cuenta saveAccount(@RequestBody Cuenta cuenta){
        return cuentaService.saveAccount(cuenta);
    }

    @DeleteMapping("/{id}")
    public String deleteAccountById(@PathVariable("id") long id){
        if(cuentaService.deleteAccountById(id))
            return "Se ha eliminado la cuenta";
        else
            return "NO se ha eliminado la cuenta";
    }
}
