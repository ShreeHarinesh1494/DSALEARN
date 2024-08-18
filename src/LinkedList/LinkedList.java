package LinkedList;

class LinkedList
{
    private Node head;
    private Node tail;
    private int length;

    class Node
    {
        int value;
        Node next;

        Node(int value)
        {
            this.value = value;
        }
    }

    LinkedList(int value)
    {
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
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
            length++;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
            length++;
        }

    }

    public Node removeLast()
    {
        Node temp = head;
        Node pre = head;

        if(head==null)
        {
            return null;
        }

        while(temp.next!=null)
        {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next=null;
        length--;

        if(length==0)
        {
            head=null;
            tail=null;
        }
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

        newNode.next=head;
        head= newNode;
        length++;
    }

    public Node removeFirst()
    {
        Node temp = head;
        if(head==null)
        {
            return null;
        }

        head = temp.next;
        temp.next=null;
        length--;
        if(length==0)
        {
            tail=null;
        }

        return temp;


    }

    public Node getValue(int index)
    {
        Node temp = head;
        if(index<0 || index>=length)
        {
            return null;
        }

        for(int i=0;i<index;i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    public boolean setValue(int index,int value)
    {
        Node temp = getValue(index);


        if(temp!=null)
        {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insertValue(int index,int value)
    {
        if(index<0 || index>length)
        {
            return true;
        }

        if(length==0)
        {
            prepend(value);
            return  true;
        }

        if(length==index)
        {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = getValue(index-1);
        newNode.next =  temp.next ;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node removeNode(int index)
    {
        if(index<0||index>length)
        {
            return null;
        }

        if(length==0)
        {
            removeFirst();
        }

        if(length==index)
        {
            removeLast();
        }

        Node prev = getValue(index-1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next=null;
        length--;
        return temp;
    }




}
