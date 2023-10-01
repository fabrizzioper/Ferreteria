/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author fabri
 */

 class NodoProducto {
        private Productos producto;
        private NodoProducto izquierdo;
        private NodoProducto derecho;

        public NodoProducto(Productos producto) {
            this.producto = producto;
            this.izquierdo = null;
            this.derecho = null;
        }

        public Productos getProducto() {
            return producto;
        }

        public void setProducto(Productos producto) {
            this.producto = producto;
        }

        public NodoProducto getIzquierdo() {
            return izquierdo;
        }

        public void setIzquierdo(NodoProducto izquierdo) {
            this.izquierdo = izquierdo;
        }

        public NodoProducto getDerecho() {
            return derecho;
        }

        public void setDerecho(NodoProducto derecho) {
            this.derecho = derecho;
        }
    }