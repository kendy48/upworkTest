package com.upwork.test.main;

import com.upwork.test.exception.Element;
import com.upwork.test.exception.NetworkException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * Created by kendy on 06/02/17.
 */
public class Network {
    private Integer elementsQty = 0;

    private HashMap<Integer, Element> elements = new HashMap<Integer, Element>();

    public Network(Integer elementsQty) throws NetworkException{
        //Validate number of elements should be positive
        if(elementsQty <=0 ){
            throw new NetworkException();
        }
        this.elementsQty = elementsQty;
    }

    public void connect(Integer id1, Integer id2) throws NetworkException{
        //check that elements has a valid value
        if(id1 < 0 || id2 < 0){
            throw new NetworkException();
        }

        //check that elements have a valid range
        if(id1 >= elementsQty || id2 >= elementsQty){
            throw new NetworkException();
        }

        Element elm1 = getElement(id1);
        Element elm2 = getElement(id2);
        elm1.link(elm2);
        elm2.link(elm1);

    }

    public Boolean query(Integer id1, Integer id2) throws NetworkException{
        //check that elements has a valid value
        if(id1 < 0 || id2 < 0){
            throw new NetworkException();
        }

        //check that elements have a valid range
        if(id1 >= elementsQty || id2 >= elementsQty){
            throw new NetworkException();
        }

        Element elm1 = getElement(id1);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(elm1.getId());
        doSearch(ids, elm1);

        if(ids.contains(id2)){
            return true;
        } else {
            return false;
        }
    }

    private void doSearch(List<Integer> ids, Element elm){
        for(Element linkElement: elm.getLinks()){
            if(ids.contains(linkElement.getId())){
                continue;
            }
            ids.add(linkElement.getId());
            doSearch(ids, linkElement);
        }
    }

    private Element getElement(Integer id) throws NetworkException{
        if(elements.get(id) != null){
            return elements.get(id);
        } else {
            Element elm = new Element(id);
            elements.put(id, elm);
            return elm;
        }
    }
}
