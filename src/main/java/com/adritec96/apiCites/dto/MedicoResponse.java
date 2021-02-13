package com.adritec96.apiCites.dto;


import com.adritec96.apiCites.model.Medico;


public class MedicoResponse extends UsuarioResponse implements Response {

    private String ncol;

    
    public MedicoResponse(int id, String nombre, String apellidos, String usuario, String ncol) {
        super(id, nombre, apellidos, usuario);
        this.ncol = ncol;
    }
    
    public static MedicoResponse toResponse(Medico medico){
        return new MedicoResponse(
                medico.getId(),
                medico.getNombre(),
                medico.getApellidos(),
                medico.getUsuario(),
                medico.getNcol()
        );
    }

    public String getNcol() {
        return ncol;
    }
}
