class node {
	int rollNo;
    String name;
    
	node lchild;
	node rchild;
}

class Binary {
    node root=null,parent=null,location=null; // location = exact location, parent = location's parent, root = first elem of tree
    
	void display(int rollNo){
        find(rollNo);
        if (location == null){
            System.out.println("Student not found");
        } else {
            System.out.println("Name : " + location.name);
            System.out.println("Roll No : " + location.rollNo);
        }
    }

    void find(int item) {
		node ptr, ptrsave;
		
		if(root==null) { // if null then tree is empty
			location = null;
			parent = null;
			return;
		}

		if(item==root.rollNo) { // if found then item = root.info
			location = root;
			parent = null;
			return;
		}

		if(item<root.rollNo) // if not root then either left (<) or right (>) of root
            ptr=root.lchild;
		else 
            ptr=root.rchild;
		ptrsave=root;

		while(ptr!=null){ // find the exact location
			if(item==ptr.rollNo) {// if found then get location and return
				location = ptr;
				parent = ptrsave;
				return;
			}
			ptrsave=ptr; // if not found then search further by going left or right
			if(item<ptr.rollNo)
                ptr=ptr.lchild;
			else 
                ptr=ptr.rchild;
		}
        location=null;
        parent=ptrsave;
    }
    
    void insert(String name, int rollNo) {
        node tmp; //,parent=new node(), location=new node();
        find(rollNo);
        if(root!=null && location!=null) {
            System.out.println("Item already present");
            return;
        }

        tmp=new node();
        tmp.name=name;
        tmp.rollNo = rollNo;
        tmp.lchild=null;
        tmp.rchild=null;

        if(parent==null) {
            root=tmp;
        }
        else if(rollNo<parent.rollNo) {
            parent.lchild=tmp;
        } else {
            parent.rchild=tmp;
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        Binary o = new Binary();
        o.insert("Jasim", 1);
        o.insert("Sara", 2);
        o.insert("Hifza", 3);
        o.display(3);
    }
}