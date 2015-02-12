package com.company;

public class MyArrayList implements MyList {
    private static final float GOLD_NUMB = 1.62f;
    private static final int FIRST_SIZE = 16;
    private int internalSize = 0;
    private Object[] elements = new Object[FIRST_SIZE];

    private void checkRise() {
        if(internalSize >= elements.length) {
            elements = riceLength(elements);
        }
    }
    private  void checkDescend() {
        if(internalSize*2 <= elements.length) {
            elements = descendLength(elements);
        }
    }
    private Object[] riceLength(Object[] src) {
        int newLength = (int)(src.length * GOLD_NUMB);
        Object[] dest = new Object[newLength];
        System.arraycopy(src,0,dest,0,src.length);
        return  dest;
    }
    private Object[]  descendLength (Object[] src) {
        int newLength = (int)(internalSize * GOLD_NUMB);
        Object[] dest = new Object[newLength];
        System.arraycopy(src,0,dest,0,src.length);
        return  dest;
    }

    private void checkBounds(int poss) {
        if (poss < 0 | poss >= internalSize ) {
            throw new IndexOutOfBoundsException("А туда ли ты попал своим индексом?");
        }
    }
    @Override
    public void add(Object o) {
        elements[internalSize] = o;
        internalSize++;
        checkRise();
    }

    @Override
    public int insert (int poss, Object o) {
        checkBounds(poss);
        System.arraycopy(elements,poss,elements,poss+1,internalSize-poss-1);
        put(poss,o);
        internalSize++;
        checkRise();
        return 0;
    }

    public void put(int poss, Object o) {
        checkBounds(poss);
        elements[poss] = o;
    }

    @Override
    public int indexOf(Object o) {
        for(int i =0; i < internalSize; i++) {
            if (elements[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object get(int poss) {
        checkBounds(poss);
        return elements[poss];
    }

    @Override
    public int size() {
        return internalSize;
    }

    @Override
    public boolean isEmpty() {
        if (internalSize <= 0) {
            return true;
        }
        else {
            for(int i = 0; i < internalSize-1; i++) {
                if (elements[i] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public Object remove(int poss) {
        checkBounds(poss);
        Object temp = elements[poss];
        System.arraycopy(elements,poss+1,elements,poss,elements.length-poss-1);
        internalSize--;
        checkDescend();
        return temp;
    }

    public void remove() {
        internalSize--;
        checkDescend();
    }

    @Override
    public void clear() {
        elements = new Object[elements.length];
    }

    @Override
    public boolean contains(Object o) {
        for(int i = 0; i < internalSize-1; i++){
            if(elements[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String toString ="";
        for (int i = 0; i < this.internalSize; i++) {
            toString += elements[i]+" ";
        }
        return toString;
    }

}
