package com.ahoy.ccee.dto;

import lombok.Getter;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "agente")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "codigo", "data", "regiao" })
@Getter
@Setter
public class Agente {
    private String codigo;
    private Date data;
    private List<Regiao> regiao;


}
