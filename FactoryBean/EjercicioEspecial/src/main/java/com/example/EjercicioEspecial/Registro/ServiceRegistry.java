package com.example.EjercicioEspecial.Registro;

public interface ServiceRegistry {
    public <T> AdapterService<T> getService(String serviceName);
}
