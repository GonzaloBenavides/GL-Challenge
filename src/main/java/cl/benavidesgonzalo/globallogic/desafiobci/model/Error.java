package cl.benavidesgonzalo.globallogic.desafiobci.model;

import java.util.Date;

public class Error {
    public int codigo;
    public String detail;
    public Date timestamp;

    public Error(int codigo, String detail, Date timestamp) {
        this.codigo = codigo;
        this.detail = detail;
        this.timestamp = timestamp;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
    public Date getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    
}
