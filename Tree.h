#pragma once
#include <iostream>
#include "Node.h"

using namespace std;

class Tree {
public:
  Node* Root;
	Tree(void);
	void Inorder(Node* x);
	Node* Max(Node* x);
	Node* Search(Node* x, int k );
	Node* Successor(Node* x );
	void Clear(Node* x);
	void Insert(Node* InsertNode);
	void Delete(Node* DeleteNode);
	~Tree(void);
};
