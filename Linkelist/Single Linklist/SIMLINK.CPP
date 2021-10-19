#include<iostream.h>
#include<stdlib.h>

void create_list(int);
void addatbeg(int);
void addafter(int,int);
void del(int);
void display();
void count();
void rev();
void search(int);

struct node
{
	int info;
	struct node *link;
}*start;

void main()
{
	int choice,n,m,position,i;
	start=NULL;
	while(1)
	{
		cout<<"1. Create List"<<endl;
		cout<<"2. Add at beginning"<<endl;
		cout<<"3. Add after"<<endl;
		cout<<"4. Delete"<<endl;
		cout<<"5. Display"<<endl;
		cout<<"6. Count"<<endl;
		cout<<"7. Reverse"<<endl;
		cout<<"8. Search"<<endl;
		cout<<"9. Quit"<<endl;

		cout<<"Enter ur choice"<<endl;
		cin>>choice;
		switch(choice)
		{
			case 1:
				cout<<"How many nodes u want:"<<endl;
				cin>>n;
				for(i=0;i<n;i++)
				{
					cout<<"Enter the element"<<endl;
					cin>>m;
					create_list(m);
				}
				break;
			case 2:
				cout<<"Enter the element"<<endl;
				cin>>m;
				addatbeg(m);
				break;
			case 3:
				cout<<"Enter the element"<<endl;
				cin>>m;
				cout<<"Enter the position after which this element is inserted"<<endl;
				cin>>position;
				addafter(m,position);
				break;
			case 4:
				if(start==NULL)
				{
					cout<<"List is empty"<<endl;
					continue;
				}
				cout<<"Enter the element for deletion"<<endl;
				cin>>m;
				del(m);
				break;
			case 5:
				display();
				break;
			case 6:
				count();
				break;
			case 7:
				rev();
				break;
			case 8:
				cout<<"Enter the element to be searched"<<endl;
				cin>>m;
				search(m);
				break;
			case 9:
				exit(1);
			default:
				cout<<"Wrong choice"<<endl;
		}
	}
}

void create_list(int data)
{
	struct node *q,*tmp;
	tmp=new(struct node);
	tmp->info=data;
	tmp->link=NULL;

	if(start==NULL)	  start=tmp;	/*if list is empty*/
	else    	/*element inserted at end*/
	{
		q=start;
		while(q->link!=NULL)	q=q->link;
		q->link=tmp;
	}
}

void addatbeg(int data)
{
	struct node *tmp;
	tmp=new(struct node);
	tmp->info=data;
	tmp->link=start;
	start=tmp;
}

void addafter(int data,int pos)
{
	struct node *tmp,*q;
	int i;
	q=start;
	for(i=0;i<pos;i++)
	{
		q=q->link;
		if(q==NULL)
		{
			cout<<"There are less than "<<pos<<" elements"<<endl;
			return;
		}
	}
	tmp=new(struct node);
	tmp->link=q->link;
	tmp->info=data;
	q->link=tmp;
}
void del(int data)
{
	struct node *tmp,*q;
	if(start->info==data)
	{
		tmp=start;
		start=start->link;	/*first element deleted*/
		delete(tmp);
		return;
	}
	q=start;
	while(q->link->link!=NULL)
	{
		if(q->link->info==data)	       /*element deleted in between*/
		{
			tmp=q->link;
			q->link=tmp->link;
			free(tmp);
			return;
		}
		q=q->link;
	}
	if(q->link->info==data)		/*last element deleted*/
	{
		tmp=q->link;
		free(tmp);
		q->link=NULL;
		return;
	}
	cout<<"Element "<<data<<" not found"<<endl;
}

void display()
{
	struct node *q;
	if(start==NULL)
	{
		cout<<"List is empty"<<endl;
		return;
	}
	q=start;
	cout<<"List is:"<<endl;
	while(q!=NULL)
	{
		cout<<q->info<<"   ";
		q=q->link;
	}
	cout<<endl;
}

void count()
{
	struct node *q=start;
	int cnt=0;
	while(q!=NULL)
	{
		q=q->link;
		cnt++;
	}
	cout<<"Number of elements are "<<cnt<<endl;
}

void rev()
{
	struct node *p1,*p2,*p3;
	if(start->link==NULL)  return;	/*only one element*/

	p1=start;
	p2=p1->link;
	p3=p2->link;
	p1->link=NULL;
	p2->link=p1;
	while(p3!=NULL)
	{
		p1=p2;
		p2=p3;
		p3=p3->link;
		p2->link=p1;
	}
	start=p2;
}

void search(int data)
{
	struct node *ptr=start;
	int pos=1;
	while(ptr!=NULL)
	{
		if(ptr->info==data)
		{
			cout<<"Item "<<data<<" found at position "<<pos<<endl;
			return;
		}
		ptr=ptr->link;
		pos++;
	}
	if(ptr==NULL)	cout<<"Item "<<data<<" not found in list"<<endl;
}


