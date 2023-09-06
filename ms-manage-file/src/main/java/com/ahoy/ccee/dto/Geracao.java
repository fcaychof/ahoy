package com.ahoy.ccee.dto;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "geracao")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Geracao {

    private double valor;
}
