/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ossamamehmood
 */

class Node{
    String name;
    int Roll_no;
    double gpa;
    Node lchild;
    Node rchild;
}

public class Student_Records {
    Node root=null, parent=null;
    void insert(int roll, String n , double g){
        Node temp=new Node();
        find(roll);
        
        temp.name=n;
        temp.Roll_no=roll;
        temp.gpa=g;
        temp.lchild=null;
        temp.rchild=null;
        if (parent==null){
            root=temp;
        }
        else if(roll<parent.Roll_no){
            parent.lchild=temp;
        }
        else{
            parent.rchild=temp;
        }
    }
    Node find(int roll){
        Node pointer=null, pointer_save=null;
        if(root==null)
            
            parent=null;
        else if (roll <root.Roll_no)
            pointer=root.lchild;
        
        else
            pointer=root.rchild;
            pointer_save=root;
            while(pointer!=null){
               pointer_save=pointer;
               if(roll<pointer.Roll_no)
                   pointer=pointer.lchild;
               else
                   pointer=pointer.rchild;
           }
        parent =pointer_save;
        return pointer_save;
        
    }
    void Search(int no){
        
        Node pointer =find(no);
        
        System.out.println(" ROLL NO "+pointer.Roll_no+
        " NAME "+pointer.name+" GPA "+pointer.gpa);
        
        
    }
    

    void Display(Node pointer){
        if(root==null){
            System.out.println("Tree is empty");
            return;
        }
        if(pointer!=null){
            Display(pointer.lchild);
            System.out.println(" ROLL NO "+pointer.Roll_no+" NAME "+pointer.name+" GPA "+pointer.gpa);
            Display(pointer.rchild);
        }    
    }
    public static void main(String[] args) {
        Student_Records obj= new Student_Records();
        obj.insert(5, "Ossama" ,3.8);
        obj.insert(4, "Hamza" ,3.7);
        obj.insert(9, "Ali" ,3.0);
        obj.insert(1, "Hanan" ,3.5);
        obj.Display(obj.root);
        System.out.println("=============================");
        System.out.println("SEARCH THE FOLLOWING ROLL NO");
        System.out.println("=============================");
        obj.Search(4);   

    }
    
}