package br.com.devolucao.backend.domain.user;

public record RegisterDTO(String login, String password, UserRole role) {
}
