#include <iostream>
#include <conio.h>
#include "Node.h"
#include "Tree.h"

using namespace std;

int main()
{
  Node node1(2);
	Node node2(34);
	Node node3(5);
	Node node4(19);

	Tree tree1;
	tree1.Insert(&node1);
	tree1.Insert(&node2);
	tree1.Insert(&node3);
	tree1.Insert(&node4);

	tree1.Inorder(tree1.Root);
	system("pause");
	tree1.~Tree();
	return 0;
}
