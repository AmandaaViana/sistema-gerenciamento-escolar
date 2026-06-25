package com.escola.gerenciamento.enums;

public enum Role {
    ADMINISTRADOR,
    GERENTE,
    USUARIO;

    private Role() {
    }


    public static Role getADMINISTRADOR() {
        return ADMINISTRADOR;
    }

    public static Role getGERENTE() {
        return GERENTE;
    }

    public static Role getUSUARIO() {
        return USUARIO;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}