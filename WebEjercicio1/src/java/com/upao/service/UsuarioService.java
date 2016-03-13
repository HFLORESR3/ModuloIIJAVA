package com.upao.service;

import com.upao.dto.Usuario;

/**
 *
 * @author Upao
 */
public class UsuarioService {
   public void validar(Usuario usuario) {
       if(usuario.getNombre().isEmpty() || usuario.getApellido().isEmpty())
           throw new RuntimeException("Falta datos");
   }
}
