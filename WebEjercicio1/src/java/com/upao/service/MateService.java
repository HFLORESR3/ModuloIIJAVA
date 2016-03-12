/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upao.service;

/**
 *
 * @author Upao
 */
public class MateService {
    public int Calcular(int n1,int n2,String operador) {
        int rpta =0;
        switch (operador) {
            case "+":
                rpta= n1+n2;
                break;
            case "-":
                rpta= n1-n2;
                break;
            case "*":
                rpta= n1*n2;
                break;
            case "/":
                rpta= n1/n2;
                break;
            default:
                rpta=0;
                break;
        }
        return rpta;
    }
}
