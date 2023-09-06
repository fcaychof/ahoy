package com.ahoy.ccee.dto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Request {
    private Agentes agentes;

    public Agentes getAgentes() { return agentes; }
    public void setAgentes(Agentes value) { this.agentes = value; }
}
