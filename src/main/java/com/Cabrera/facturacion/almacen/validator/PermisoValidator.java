package com.Cabrera.facturacion.almacen.validator;

import com.Cabrera.facturacion.almacen.entity.Permiso;
import com.Cabrera.facturacion.almacen.exception.ValidateException;

public class PermisoValidator {
    public static void save(Permiso registro) {
        if(registro.getNombre() == null || registro.getNombre().trim().isEmpty()) {
            throw new ValidateException("El nombre es requerido");
        }
        if(registro.getNombre().length() > 100) {
            throw new ValidateException("El nombre no debe exceder los 100 caracteres");
        }
    }
}
