package com.ahoy.ccee.dto;

import java.io.IOException;

public enum Sigla {
    N, NE, S, SE;

    public String toValue() {
        switch (this) {
            case N: return "N";
            case NE: return "NE";
            case S: return "S";
            case SE: return "SE";
        }
        return null;
    }

    public static Sigla forValue(String value) throws IOException {
        if (value.equals("N")) return N;
        if (value.equals("NE")) return NE;
        if (value.equals("S")) return S;
        if (value.equals("SE")) return SE;
        throw new IOException("Cannot deserialize Sigla");
    }
}
