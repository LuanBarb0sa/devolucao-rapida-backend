package br.com.devolucao.backend.dto;

import br.com.devolucao.backend.enumerated.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
