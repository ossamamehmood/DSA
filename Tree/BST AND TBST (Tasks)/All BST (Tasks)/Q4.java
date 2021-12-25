class node {
	int info;
	node lchild;
	node rchild;
}

class Binary {
    node root=null,parent=null,location=null;

    void findPredAndSuc(int item){
        // node pred=null, suc=null;
        // find(item);
        // // pred = parent;
        // System.out.println(parent.info + " " + location.info);
        // return;
        // // suc = getPredAndSuc(parent, location);

        // // System.out.println("Predecessor : " + pred.info);
        // // System.out.println("Node : " + item);
        // // System.out.println("Successor : " + suc.info);

        
            // if (root == null) return null;
            // root = root.lchild;
            // while (root.rchild != null) root = root.rchild;
            // return root;

        find(item);
        System.out.println("Current : " + location.info);
        System.out.println("pred : " + getPred(parent, location).info);
        System.out.println("suc : " + getSuc(parent, location).info);
    }

    node getSuc(node par, node loc){
        node ptr, ptrsave, suc=null;
		
		ptrsave=loc;
        if (loc.rchild!=null){
            ptr=loc.rchild;
        } else {
            if (location.info<par.info){
                return par;
            } else {
                return loc;
            }
        }

		while(ptr.lchild!=null) {
			ptrsave=ptr;
			ptr=ptr.lchild;
		}

		suc=ptr;
        return suc;
    }

    node getPred(node par, node loc) {
        node ptr, ptrsave, pred=null;
		ptrsave=loc;
        if (loc.lchild!=null){
            ptr=loc.lchild;
        } else {
            if (location.info>par.info){
                return par;
            } else {
                return loc;
            }
        }

		while(ptr.rchild!=null) {
			ptrsave=ptr;
			ptr=ptr.rchild;
		}

		pred=ptr;
        return pred;
	}

    void find(int item) {
		node ptr, ptrsave;
		
		if(root==null) { // if null then tree is empty
			location = null;
			parent = null;
			return;
		}

		if(item==root.info) { // if found then item = root.info
			location = root;
			parent = null;
			return;
		}

		if(item<root.info) // if not root then either left (<) or right (>) of root
            ptr=root.lchild;
		else 
            ptr=root.rchild;
		ptrsave=root;

		while(ptr!=null) {// find the exact location
			if(item==ptr.info) { // if found then get location and return
				location = ptr;
				parent = ptrsave;
				return;
			}
			ptrsave=ptr; // if not found then search further by going left or right
			if(item<ptr.info)	
                ptr=ptr.lchild;
			else 
                ptr=ptr.rchild;
		}
        location=null;
        parent=ptrsave;
    }
    
    void insert(int item) {
		node tmp; //,parent=new node(), location=new node();
		find(item);
		if(root!=null && location!=null) {
			System.out.println("Item already present");
			return;
		}

		tmp=new node();
		tmp.info=item;
		tmp.lchild=null;
		tmp.rchild=null;

		if(parent==null) {
			root=tmp;
		}
		else if(item<parent.info) {
			parent.lchild=tmp;
		} else {
			parent.rchild=tmp;
		}
	}


}

public class Q4 {
    public static void main(String[] args) {
        Binary o = new Binary();
        o.insert(3);
        o.insert(4);
        o.insert(6);
        o.insert(2);
        o.insert(8);
        o.findPredAndSuc(6);
    }
}