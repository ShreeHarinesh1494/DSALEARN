package DoubleLinkedList;

public class DoubleLinkedList
{
    private Node head;
    private Node tail;
    private int length;

    class Node
    {
        int value;
        Node prev;
        Node next;

        Node(int value)
        {
            this.value=value;
        }
    }

    DoubleLinkedList(int value)
    {
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length =1;
    }

    public void printList()
    {
        Node temp = head;
        while(temp!=null)
        {
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printHead()
    {
        System.out.println("Head : " + head.value);
    }

    public void printTail()
    {
        System.out.println("Tail : " + tail.value);
    }

    public void printLength()
    {
        System.out.println(length);
    }

    public void append(int value)
    {
        Node newNode = new Node(value);
        if(length==0)
        {
            head=newNode;
            tail=newNode;
        }
        else
        {
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
        length++;
    }

    public Node removeLast()
    {
        Node temp = tail;
        if(length==0)
        {
            return null;
        }
        if(length==1)
        {
            head=null;
            tail=null;
        }
        else
        {
            tail = tail.prev;
            tail.next=null;
            temp.prev=null;
        }
        length--;
        return temp;
    }

    public void prepend(int value)
    {
        Node newNode = new Node(value);
        if(length==0)
        {
            head=newNode;
            tail=newNode;
        }
        else
        {
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
        length++;
    }

    public Node removeFirst()
    {
        Node temp = head;
        if(length==0)
        {
            return null;
        }

        if(length==1)
        {
            head=null;
            tail=null;
        }
        else
        {
            head=head.next;
            head.prev=null;
            temp.next=null;
        }
        length--;
        return temp;
    }

    public Node getValue(int index)
    {
        if(index<0 || index>=length)
        {
            return null;
        }
        Node temp = head;
        if(index<length/2)
        {
            for(int i=0;i<index;i++)
            {
                temp=temp.next;
            }
        }
        else
        {
            temp=tail;
            for(int i=length-1;i>index;i--)
            {
                temp=temp.prev;
            }
        }
        return temp;
    }

    public boolean setValue(int index,int value)
    {
        Node temp = getValue(index);
        if(temp!=null)
        {
            temp.value=value;
            return true;
        }
        return false;
    }

    public boolean insert(int index,int value)
    {
        if(index<0 ||index>length)
        {
            return false;
        }
        if(index==0)
        {
            prepend(value);
            return true;
        }

        if(index==length)
        {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = getValue(index-1);
        Node after = before.next;
        before.next=newNode;
        after.prev=newNode;
        newNode.prev=before;
        newNode.next=after;
        length++;
        return true;

    }
}
