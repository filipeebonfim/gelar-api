package com.gelarapi.services;

import com.gelarapi.model.Usuario;
import com.gelarapi.repositories.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioDAO.findByLogin(login);

        if(usuario == null)
            throw new UsernameNotFoundException("Usuario não encontrado");

        return usuario;
    }
}
