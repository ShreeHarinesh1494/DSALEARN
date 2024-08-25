package HashTable;

import java.util.ArrayList;

public class HashTable
{
    private int size = 7;
    private Node[] dataMap;

    class Node
    {
        int value;
        String key;
        Node next;

        Node(String key,int value)
        {
            this.key=key;
            this.value=value;
        }
    }

    HashTable()
    {
        dataMap = new Node[size];
    }

    public void printTable()
    {
        for(int i=0;i< dataMap.length;i++)
        {
            System.out.println(i+" : ");
            Node temp = dataMap[i];
            while(temp!=null)
            {
                System.out.println(" {"+temp.key+" = "+temp.value+" }");
                temp = temp.next;
            }
        }
    }

    private int hash(String key)
    {
        int hash =0;
        char keychar[] = key.toCharArray();
        for(int i=0;i< keychar.length;i++)
        {
            int ascivalue = keychar[i];
            hash = (hash+ascivalue*23)% dataMap.length;
        }
        return hash;
    }

    public void set(String key,int value)
    {
        int index = hash(key);
        Node newNode = new Node(key,value);
        if(dataMap[index] ==null)
        {
                dataMap[index]=newNode;
        }
        else
        {
            Node temp = dataMap[index];
            while(temp!=null)
            {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int get(String key)
    {
        int index = hash(key);
        Node temp = dataMap[index];
        while (temp!=null)
        {
            if(temp.key==key)
            {
                return temp.value;
            }
            temp=temp.next;
        }
        return 0;
    }

    public ArrayList keys()
    {
        ArrayList<String> allkeys = new ArrayList<>();
        for(int i=0;i<dataMap.length;i++)
        {
            Node temp = dataMap[i];
            while(temp!=null)
            {
                allkeys.add(temp.key);
                temp = temp.next;
            }
        }
        return allkeys;
    }
}

class Main
{
    public static void main(String args[])
    {
        HashTable ht = new HashTable();
        ht.set("apple",500);
        ht.set("banana",600);
        ht.printTable();
        System.out.println(ht.keys());
    }
}
