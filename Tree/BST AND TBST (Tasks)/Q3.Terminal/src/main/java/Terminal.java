/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ossam
 */
class Node{
    
    int data;
    
    Node lchild;
    Node rchild;
}

public class Terminal {
    Node root=null, parent=null,location=null ;
    void insert(int item){
        Node temp=new Node();
        find(item);
        temp.data=item;
        
        temp.lchild=null;
        temp.rchild=null;
        if (parent==null){
            root=temp;
        }
        else if(item<parent.data){
            parent.lchild=temp;
        }
        else{
            parent.rchild=temp;
        }
    }
    void find(int item){
        Node pointer=null, pointer_save=null;
        if(root==null){
            location=null;
            parent=null;
            return;
        }
        if(root.data==item){
            location=root;
            parent=null;
            return;
        }
        else if (item <root.data)
            pointer=root.lchild;
        
        else
            pointer=root.rchild;
            pointer_save=root;
            while(pointer!=null){
                if (pointer.data==item){
                   location=pointer;//0x55
                   parent=pointer_save;//0x33
                   return;
               }
               pointer_save=pointer;
               if(item<pointer.data)
                   pointer=pointer.lchild;
               else
                   pointer=pointer.rchild;
           }
        parent =pointer_save;
        
    }
    void case_a(Node par , Node loc){
        if (par==null)
            root=null;
        if(loc==par.lchild)
            par.lchild=null;
        else
            par.rchild=null;
    }
    void delete(int item){
        find(item);
        if (location.lchild==null && location.rchild==null)
            case_a(parent,location);
    }
     void inorder(Node pointer){
        if(root==null){
            System.out.println("Tree is empty");
            return;
        }
        if(pointer!=null){
            inorder(pointer.lchild);
            System.out.println(pointer.data);
            inorder(pointer.rchild);
        }
    }
       public static void main(String[] args) {
        Terminal obj = new Terminal();
        obj.insert(80);
        obj.insert(65);
        obj.insert(95);
        obj.insert(92);
        obj.inorder(obj.root);
        System.out.println("After deletion");
        obj.delete(92);
        obj.inorder(obj.root);
        
    }
    
}