package com.company;

public class MyArrayList implements MyList {
    private static final float GOLD_NUMB = 1.62f;
    private int internalSize = 0;
    private Object[] elements = new Object[16];

    private void doRise() {
        if(internalSize >= elements.length) {
            elements = riceLength(elements);
        }
    }
    private  void doDescend() {
        if(internalSize*2 <= elements.length) {
            elements = descendLength(elements);
        }
    }
    @Override
    public void add(Object o) {
        elements[internalSize] = o;
        internalSize++;
        doRise();
    }

    public void add(Object o, int poss) {
        checkBounds(poss);
        System.arraycopy(elements,poss,elements,poss+1,internalSize-poss-1);
        set(o,poss);
        internalSize++;
        doRise();
    }

    public void set (Object o, int poss) {
        checkBounds(poss);
        elements[poss] = o;
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
    public void remove(int poss) {
        checkBounds(poss);
        System.arraycopy(elements,poss+1,elements,poss,elements.length-poss-1);
        internalSize--;
        doDescend();
    }

    public void remove() {
        internalSize--;
        doDescend();
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
            toString += elements[i] + " internalSize= " + internalSize + " length=" + elements.length +"\n";
        }
        return toString;
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

}
