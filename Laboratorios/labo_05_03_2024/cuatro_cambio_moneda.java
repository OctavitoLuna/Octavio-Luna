public class cuatro_cambio_moneda {
    public double a;
    public double opcion;
    public double dolarOficial = 6.96;
    public double dolarParaleloBarato = 8.5;
    public double dolarParaleloCaro = 9.97;
    public double euro = 7.5;

    // Constructor que acepta los valores de cambio
    public cuatro_cambio_moneda(double a, double opcion) {
        this.a = a;
        this.opcion = opcion;
    }

    public double bolivianosADolares() {
        double resultado;
        if (getOpcion() == 1) {
            resultado = getMonto() / dolarParaleloBarato;
        } else if (getOpcion() == 2) {
            resultado = getMonto() / dolarOficial;
        } else if (getOpcion() == 3) {
            resultado = getMonto() / dolarParaleloCaro;
        } else {
            resultado = getMonto() / euro;
        }
        return resultado;
    }

    public double dolaresABolivianos() {
        double resultado;
        if (getOpcion() == 1) {
            resultado = getMonto() * dolarParaleloBarato;
        } else if (getOpcion() == 2) {
            resultado = getMonto() * dolarOficial;
        } else if (getOpcion() == 3) {
            resultado = getMonto() * dolarParaleloCaro;
        } else {
            resultado = getMonto() * euro;
        }
        return resultado;
    }

    public void setMonto(int a) {
        this.a = a;
    }

    public double getMonto() {
        return a;
    }
    public void setOpcion(double opcion) {
        this.opcion = opcion;
    }

    public double getOpcion() {
        return opcion;
    }
}
