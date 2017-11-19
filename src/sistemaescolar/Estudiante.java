/*
 * The MIT License
 *
 * Copyright 2017 Gustavo-A Salazar.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package sistemaescolar;

import java.io.Serializable;

/**
 *
 * @author Gustavo-A Salazar
 */
public class Estudiante implements Serializable{

    private String nombreCompleto, solicitarAusencia;
    private int id, calificacion;
    private boolean inscrito, retirado, ausente;

    public Estudiante() {
    }
    
    public Estudiante(int id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the nombreCompleto
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the calificacion
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @param calificacion the calificacion to set
     */
    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * @return the inscrito
     */
    public boolean isInscrito() {
        return inscrito;
    }

    /**
     * @param inscrito the inscrito to set
     */
    public void setInscrito(boolean inscrito) {
        this.inscrito = inscrito;
    }

    /**
     * @return the retirado
     */
    public boolean isRetirado() {
        return retirado;
    }

    /**
     * @param retirado the retirado to set
     */
    public void setRetirado(boolean retirado) {
        this.retirado = retirado;
    }

    /**
     * @return the ausente
     */
    public boolean isAusente() {
        return ausente;
    }

    /**
     * @param ausente the ausente to set
     */
    public void setAusente(boolean ausente) {
        this.ausente = ausente;
    }

    /**
     * @return the solicitarAusencia
     */
    public String getSolicitarAusencia() {
        return solicitarAusencia;
    }

    /**
     * @param solicitarAusencia the solicitarAusencia to set
     */
    public void setSolicitarAusencia(String solicitarAusencia) {
        this.solicitarAusencia = solicitarAusencia;
    }
}
