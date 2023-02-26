package View;

import java.security.Key;

public class hashing {
    int keys[];
    int values[];
    int capacity;
    hashing (int size){
        this.capacity=size;
//        size ko diye ni huncha
        keys=new int[capacity];
        values=new int[capacity];
        for (int i=0;i<capacity;i++){
            keys[i]=-1;
            values[i]=-1;
        }
    }
    public void insert(int key,int value){
        int temp=key%10;
        int i=temp;
//empty cha ki nai vanera herne paila keys if cha vane key lai gayera ith index ma place gardini
//
        if(keys[i]==-1){
            keys[i]=key;
            values[i]=value;
        }
        else  if(keys[i]==key){
            values[i]=value;
        }
        else {
            do{
//            linear probbing ma if thau empty chaina vane increase gardai jani i
            i=(i+1)%10;
//            increase gareko position empty cha ki nai check garna paryo linear probbing ma
            if(keys[i]==-1) {
                keys[i] = key;
                values[i] = value;
                break;
            }
            }
            while (i!=temp);

            }

        }
    public int get(int key){
        int temp=key%10;
        while (keys[temp]!=-1){
            if (keys[temp]==key){
                return values[temp];
            }
            temp=(temp+1)%10;
        }
        return -1;
    }
}
