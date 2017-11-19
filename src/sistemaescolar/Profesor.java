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
public class Profesor extends Persona implements Serializable{

    private String nombreCompleto, materiaQueimparte;
    private int id;

    public Profesor() {
    }
    
    public Profesor(int id, String nombreCompleto, String materiaQueimparte) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.materiaQueimparte = materiaQueimparte;
    }

   /**
     * @return the nombreCompleto
     */
    @Override
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * @param nombreCompleto the nombreCompleto to set
     */
    @Override
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * @return the materiaQueimparte
     */
    public String getMateriaQueimparte() {
        return materiaQueimparte;
    }

    /**
     * @param materiaQueimparte the materiaQueimparte to set
     */
    public void setMateriaQueimparte(String materiaQueimparte) {
        this.materiaQueimparte = materiaQueimparte;
    }

    /**
     * @return the id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }
}
