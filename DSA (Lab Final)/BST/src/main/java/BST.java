/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ossamamehmood
 */

class node
{
	int info;
	node lchild;
	node rchild;
}

public class BST {

    node root = null, parent = null, location = null;

    public void find(int item) {

        node ptr, ptrsave;

        if (root == null) {
            location = null;
            parent = null;
            return;
        }
        if (item == root.info) {
            location = root;
            parent = null;
            return;
        }
        if (item < root.info) {
            ptr = root.lchild;
        } else {
            ptr = root.rchild;
        }
        ptrsave = root;

        while (ptr != null) {
            if (item == ptr.info) {
                location = ptr;
                parent = ptrsave;
                return;
            }
            ptrsave = ptr;
            if (item < ptr.info) {
                ptr = ptr.lchild;
            } else {
                ptr = ptr.rchild;
            }
        }
        location = null;
        parent = ptrsave;
    }

    public void insert(int item) {
        node tmp;
        //,parent=new node(), location=new node();

        find(item);

        if (root != null && location != null) {
            System.out.println("Item already present");
            return;
        }
        tmp = new node();
        tmp.info = item;
        tmp.lchild = null;
        tmp.rchild = null;

        if (parent == null) {
            root = tmp;

        } else if (item < parent.info) {
            parent.lchild = tmp;

        } else {
            parent.rchild = tmp;
        }
    }

    public void display(node ptr) {

        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        if (ptr != null) {
            display(ptr.lchild);
            System.out.println(ptr.info);
            display(ptr.rchild);
        }
    }

    public void casea(node par, node loc) {
        if (par == null) {
            root = null;
        } else if (loc == par.lchild) {
            par.lchild = null;
        } else {
            par.rchild = null;
        }
    }

    public void caseb(node par, node loc) {
        node child;

        if (loc.lchild != null) {
            child = loc.lchild;
        } else {
            child = loc.rchild;
        }

        if (par == null) {
            root = child;
        } else if (loc == par.lchild) {
            par.lchild = child;
        } else {
            par.rchild = child;
        }
    }

    public void casec(node par, node loc) {
        node ptr, ptrsave, suc, parsuc;

        ptrsave = loc;
        ptr = loc.rchild;
        while (ptr.lchild != null) {
            ptrsave = ptr;
            ptr = ptr.lchild;
        }
        suc = ptr;
        parsuc = ptrsave;

        if (suc.lchild == null && suc.rchild == null) {
            casea(parsuc, suc);
        } else {
            caseb(parsuc, suc);
        }

        if (par == null) {
            root = suc;
        } else if (loc == par.lchild) {
            par.lchild = suc;
        } else {
            par.rchild = suc;
        }

        suc.lchild = loc.lchild;
        suc.rchild = loc.rchild;
    }

    public void delete(int item) {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        find(item);

        if (location == null) {
            System.out.println("Item not present in tree");
            return;
        }

        if ((location.lchild == null) && (location.rchild == null)) {
            casea(parent, location);
        }
        if ((location.lchild != null) && (location.rchild == null)) {
            caseb(parent, location);
        }
        if ((location.lchild == null) && (location.rchild != null)) {
            caseb(parent, location);
        }
        if ((location.lchild != null) && (location.rchild != null)) {
            casec(parent, location);
        }
    }

    public static void main(String[] args) {
        
         // a) Display the Post Order Traversal 
        BST obj1 = new BST();
        
        // Displaying node : Insertion in tree
        
        System.out.println("- - - - - - - - - - ");
        System.out.println(" Displaying Node" );
        System.out.println("- - - - - - - - - - ");
        
        
        obj1.insert(100);
        obj1.insert(200);
        obj1.insert(300);
        obj1.insert(400);
        obj1.insert(500);

        // b) Funtion for delecting node 200 
        obj1.display(obj1.root);
        
        System.out.println("- - - - - - - - - - ");
        System.out.println(" After deletion" );
        System.out.println("- - - - - - - - - - ");
        
        // Delecting Node from BST
        obj1.delete(200); 
        obj1.display(obj1.root);

    }
}
        
