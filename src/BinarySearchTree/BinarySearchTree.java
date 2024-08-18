package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class BinarySearchTree
{
    private Node root;
    class Node
    {
        int value;
        Node left;
        Node right;

        Node(int value)
        {
            this.value = value;
        }
    }

    public boolean insert(int value)
    {
        Node newNode = new Node(value);
        if(root==null)
        {
            root = newNode;
            return true;
        }

        Node temp = root;
        while(true)
        {
            if(temp.value==newNode.value)
            {
                return false;
            }

            if(temp.value> newNode.value)
            {
                if(temp.left==null)
                {
                    temp.left=newNode;
                    return true;
                }
                temp = temp.left;
            }
            else
            {
                if(temp.right==null)
                {
                    temp.right=newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public ArrayList<Integer> BFS()
    {
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        queue.add(root);

        while(queue.size()>0)
        {
            currentNode = queue.remove();
            result.add(currentNode.value);

            if(currentNode.left!=null)
            {
                queue.add(currentNode.left);
            }

            if(currentNode.right!=null)
            {
                queue.add(currentNode.right);
            }
        }
        return result;
    }

    public ArrayList<Integer> DFSPreOrder()
    {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse
        {
            Traverse(Node currentNode)
            {
                result.add(currentNode.value);
                if(currentNode.left!=null)
                {
                    new Traverse(currentNode.left);
                }
                if(currentNode.right!=null)
                {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return result;
    }

    public ArrayList<Integer> DFSPostOrder()
    {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse
        {
            Traverse(Node currentNode)
            {

                if(currentNode.left!=null)
                {
                    new Traverse(currentNode.left);
                }
                if(currentNode.right!=null)
                {
                    new Traverse(currentNode.right);
                }
                result.add(currentNode.value);
            }
        }
        new Traverse(root);
        return result;
    }

    public ArrayList<Integer> DFSInOrder()
    {
        ArrayList<Integer> result = new ArrayList<>();

        class Traverse
        {
            Traverse(Node currentNode)
            {

                if(currentNode.left!=null)
                {
                    new Traverse(currentNode.left);
                }
                result.add(currentNode.value);
                if(currentNode.right!=null)
                {
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return result;
    }

    public int calculateheight()
    {
        return calculateheight(root);
    }

    private int calculateheight(Node root)
    {
        if(root==null)
        {
            return -1;
        }

        int leftheight = calculateheight(root.left);
        int rightheight = calculateheight(root.right);
        return Math.max(leftheight,rightheight)+1;
    }

    public int sumofleaf()
    {
        return  sumofleaf(root);
    }

    private int sumofleaf(Node root)
    {
        if(root==null)
        {
            return 0;
        }

        if(root.left==null && root.right==null)
        {
            return root.value;
        }

        return sumofleaf(root.left)+sumofleaf(root.right);
    }

    public void printList(ArrayList<Integer> list)
    {
        for(int i=0;i<list.size();i++)
        {
            System.out.print(list.get(i)+" ");
        }
    }
}
