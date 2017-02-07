package com.upwork.test.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kendy on 06/02/17.
 */
public class Element {
    private Integer id;

    private List<Element> links = new ArrayList<Element>();

    public Element(Integer id) throws NetworkException{
        if(id < 0){
            throw new NetworkException();
        }
        this.id = id;
    }

    public Integer getId(){
        return this.id;
    }

    public void link(Element element){
        this.links.add(element);
    }

    public List<Element> getLinks(){
        return this.links;
    }

}
