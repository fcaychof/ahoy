package com.ahoy.ccee.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "agente")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Regiao {

    private Compra geracao;
    private Compra compra;
    private Compra precoMedio;
    private Sigla sigla;

}
