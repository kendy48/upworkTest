package com.upwork.test.main;

import com.upwork.test.exception.NetworkInitializationException;
import com.upwork.test.exception.NetworkOutOfRangeException;
import com.upwork.test.model.Element;
import com.upwork.test.exception.NetworkException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kendy on 06/02/17.
 */
public class Network {
    //Max number of allow elements
    private Integer elementsQty = 0;

    //Elements on the network
    private HashMap<Integer, Element> elements = new HashMap<Integer, Element>();


    /*
        Creates a new Network
     */
    public Network(Integer elementsQty) throws NetworkException{
        //Validate number of elements should be positive
        if(elementsQty <=0 ){
            throw new NetworkInitializationException();
        }
        this.elementsQty = elementsQty;
    }

    /*
        Connects two nodes bidirectional
     */
    public void connect(Integer id1, Integer id2) throws NetworkException{
        checkNodes(id1, id2);

        Element elm1 = getElement(id1);
        Element elm2 = getElement(id2);
        elm1.link(elm2);
        elm2.link(elm1);

    }

    /*
        Check if two nodes are connected
     */
    public Boolean query(Integer id1, Integer id2) throws NetworkException{
        checkNodes(id1, id2);

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

    /*
        Deep search algorithm
     */
    private void doSearch(List<Integer> ids, Element elm){
        for(Element linkElement: elm.getLinks()){
            if(ids.contains(linkElement.getId())){
                continue;
            }
            ids.add(linkElement.getId());
            doSearch(ids, linkElement);
        }
    }

    /*
        Check if the nodes have a valid range value
     */
    private void checkNodes(Integer id1, Integer id2) throws NetworkException{
        //check that elements have a valid range
        if(id1 >= elementsQty || id2 >= elementsQty){
            throw new NetworkOutOfRangeException();
        }
    }

    /*
       If the Element exist return an Element from the list otherwise returns a new Element
     */
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
