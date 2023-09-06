package com.ahoy.ccee.dto;


import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "agentes")
@XmlAccessorType(XmlAccessType.FIELD)
@Getter
@Setter
public class Agentes {
    private List<Agente> agente;

}




