package org.example;

public class Counter {
    private Integer internalVar;

    public Integer getInternalVar() {
        return internalVar;
    }

    public void setInternalVar(Integer internalVar) {
        this.internalVar = internalVar;
    }

    public Counter(Integer internalVariable) {
        this.internalVar = internalVariable;
    }

    public int countVar(int vari){
        return vari + 1;
    }
}
