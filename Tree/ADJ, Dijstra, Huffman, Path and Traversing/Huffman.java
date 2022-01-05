
package javaapplication14;
//@author  ausaf,usman
class Node
{
      int info;
      Node link = null;
      Node left = null;
      Node right = null;

      Node start = null;
      int MajorSum = 0;

      Node root = null;
      Node ptr=null;
       Node p = null;

      void insert(int item[])
      {
          for (int i = 0; i < item.length; i++) {
              MajorSum = MajorSum + item[i];
          }
        for(int i = 0; i < item.length; i++)
        {
            Node temp=new Node();
            temp.info=item[i];
            temp.link=null;
            if(start==null)
            {
                start=temp; 
            }   	
            else    	
            {
		Node q = start;
		while(q.link!=null)	q=q.link;
		q.link=temp;
            }
        }
      }
      void createSecondList(Node t)
      {
          if(p==null)
            {
                p=t; 
            }   	
            else    	
            {
		Node q = p;
		while(q.link!=null)	q=q.link;
		q.link=t;
            }         
      }
      void createList(int sum)
      {
            Node temp=new Node();
            temp.info=sum;
            temp.link=null;
            if(start==null)
            {
                start=temp; 
            }   	
            else    	
            {
		Node q = start;
		while(q.link!=null)	q=q.link;
		q.link=temp;
            }         
      }
int prev = 0;
      void Huff(Node next)
      {       
          int min1 = minimum1();
          int min2 = minimum2();
          int sum = min1 + min2;
          System.out.println("sum = "+sum);
          
          ptr = SubTree(sum, min1, min2);

          if(root == null)
          {
              root = ptr;
          }
          
          if(root.info == ptr.left.info)
              {
                  ptr.left = root;
                  root=ptr; 
                  
              }
          
              if(root.info == ptr.right.info)
              {
                  ptr.right = root;
                  root=ptr; 

              }
              
         if(ptr.info!=root.info && ptr.info != root.left.info && ptr.info != root.right.info){
             createSecondList(ptr);
//p = ptr;
          }           
          if(sum == MajorSum)
          { 
              Node p1 = p;
              while(p1!=null)
            {
              if(root.right.info == p1.info)
              {
                  root.right = p1;
              }
              if(root.left.info == p1.info)
              {
                  root.left = p1;
              }
              check(p1);
              p1=p1.link;
          }   
              return;
          }
          else
          {
          
            createList(sum);
            display();
              
            Node p1 = start;
            Huff(p1);
          }
          return ;
      }
    void last()
    {
         Node p1 = p;
               System.out.println("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"+p.info);   
         System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSs"+p.left.info);
         System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR"+p.right.info);
            while(p1!=null)
            {
              check(p1);
              p1=p1.link;
            } 
            
    }
      Node SubTree(int sum, int min1, int min2)
      {
          Node q = new Node();
          Node q1 = new Node();
          Node q2 = new Node();
          q.info = sum;
          q1.info= min1;
          q2.info = min2;
          if(min1 < min2)
          {
             q.left = q1;     
             q.right = q2;
          }
          if(min2 < min1)
          {
              q.left = q2;
              q.right = q1;             
          }
          if(min1 == min2)
          {
              q.left = q1;
              q.right = q2;
          }
          System.out.println("main = "+q.info);
          System.out.println("leftmin = "+q.left.info);
          System.out.println("rightmin = "+q.right.info);
          return q;
      }
      int minimum1()
      {
          
          Node q = start;
          int min1 = q.info;
          while(q.link != null)
          {                    
              if(min1 > q.link.info)
              {
                  min1 = q.link.info;
              }
              q = q.link;
          }
          del(min1);
          System.out.println("min1 = "+min1);    
          display();
          return min1;
      }
      int minimum2()
      {
         Node q = start;
          int min2 = q.info;
          while(q.link != null)
          {                    
              if(min2 > q.link.info)
              {
                  min2 = q.link.info;
              }
              q = q.link;
          }
          del(min2);
          System.out.println("min2 = "+min2);
          display();
          return min2;
      }
    public void del(int data)
    {   
	Node tmp,q;
	if(start.info==data)
	{
		tmp=start;
		start=start.link;	/*first element deleted*/
		tmp = null;
		return;
	}
	q=start;
	while(q.link.link!=null)
	{
		if(q.link.info==data)	       /*element deleted in between*/
		{
			tmp=q.link;
			q.link=tmp.link;
			tmp = null;
			return;
		}
		q=q.link;
	}
	if(q.link.info==data)		/*last element deleted*/
	{
		tmp=q.link;
		
		q.link=null;
		return;
	}
	System.out.println("Element "+data+" not found");
    }

    void inorder(Node ptr)
{
	if(root==null)
	{
            System.out.println(""+ptr.info);
		return;
	}
         if(ptr!=null)
	{
	
                inorder(ptr.left);
		System.out.println(ptr.info);
		inorder(ptr.right);
	}
         
}
    Node pr = root;

void check(Node s)
{

         if(s.info == root.right.right.info)
            root.right.right.right = s;   

        if(pr!=null)
	{
            check(pr.left);
	      if(pr.info == s.info)
                {
                   pr=s;   
                }  	
            check(pr.right);
            	if(pr.info == s.info)
                {
                   pr=s;   
                }
	}
  
}

      void display()
      {
          Node q = start;
          while(q!=null)
          {
              System.out.print(q.info+" ");
              q=q.link;
          }
          System.out.println();
      }
}
      


public class JavaApplication14 {

    public static void main(String[] args) {
      Node n=new Node();
      Node l;
      int item[] = {10,3,31,2,6,12,17};
      n.insert(item);
      n.display();
    n.Huff(n.start);
        System.out.println("LAST");
        System.out.println();
    n.last();
      n.display();
        System.out.println("Inorder");
      n.inorder(n.root);
    }
 
}
