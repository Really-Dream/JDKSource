package dream.lang;

import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by H.J
 * 2018/6/8
 */
public final class String implements Serializable,Comparable<String>,CharSequence {

    private final char value[];

    private int hash;

    private static final long serialVersionUID = -6849794470754667710L;

    private static final ObjectStreamField[] serialPersistentFields = new ObjectStreamField[0];

    public String(){
        this.value = "".value;
    }

    public String(String original) {
        this.value = original.value;
        this.hash = original.hash;
    }

    public String(char value[]){
        this.value = Arrays.copyOf(value,value.length);
    }

    public String(char value[],int offset,int count){
        if(offset < 0){
            throw new StringIndexOutOfBoundsException(offset);
        }
        if(count <= 0){
            if(count < 0){
                throw new StringIndexOutOfBoundsException(count);
            }
            if(offset <= value.length){
                this.value = "".value;
                return;
            }
        }

        if(offset > value.length - count){
            throw new StringIndexOutOfBoundsException(offset+count);
        }
        this.value = Arrays.copyOfRange(value,offset,offset+count);
    }

}
