package com.bd.sitebd.model;

import java.util.Map;

public class Tool {

    public static Cliente converterCliente(Map<String,Object> registro){
        //Como registro.get retorna Object, devemos usar o polimorfismo
        //de subtipos (downcast) para recuperar os tipos originais.
        return new Cliente((Integer) registro.get("id")
                          ,(String) registro.get("nome")
                          ,(String) registro.get("cpf")
                          ,(String) registro.get("celular")
                          ,(String) registro.get("endereco"));
    }

}
