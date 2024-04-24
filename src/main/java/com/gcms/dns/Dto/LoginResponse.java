package com.gcms.dns.Dto;

import lombok.*;
/**
 * DTO (Data Transfer Object) para encapsular la respuesta de una solicitud de inicio de sesión.
 * Este objeto incluye un mensaje y un estado booleano para indicar el éxito o fracaso de la operación.
 *
 * @Setter Genera automáticamente los métodos setters para todos los campos.
 * @Getter Genera automáticamente los métodos getters para todos los campos.
 * @Builder Implementa el patrón de diseño Builder para esta clase, facilitando la creación de objetos.
 * @AllArgsConstructor Genera un constructor con todos los campos de la clase como parámetros.
 * @NoArgsConstructor Genera un constructor sin parámetros, facilitando la inicialización vacía de la clase.
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {

    private String Message;
    private boolean Status;
}