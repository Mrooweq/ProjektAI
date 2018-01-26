package com.projekt.ai.bll.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2017-11-05.
 */


public class MainAssembler<In, Out> {

    public Out toDto(In in){
        return null;
    }

    public List<Out> toDtoList(List<In> inList){
        List<Out> listOut = new ArrayList<>();

        for (In in : inList) {
            listOut.add(toDto(in));
        }

        return listOut;
    }

    public In fromDto(Out out){
        return null;
    }

    public List<In> fromDtoReverseList(List<Out> outList){
        List<In> listIn = new ArrayList<>();

        for (Out out : outList) {
            listIn.add(fromDto(out));
        }

        return listIn;
    }
}
