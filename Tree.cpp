#include "Tree.h"
#include <iostream>

using namespace std;

Tree::Tree(void) {
  Root = NULL;
}

void Tree::Inorder(Node* x) {
	if(x != NULL) {
		Inorder(x->left);
		cout << x->key << " ,";
		Inorder(x->right);
	}
}

Node* Tree::Max(Node* x) {
	while(x->right != NULL) {
		x = x->right;
	}
	return x;
}

Node* Tree::Search(Node* x, int k) {
	if(x == NULL || x->key == k) return x;
	if(k < x->key) return Search(x->left, k);
	else return Search(x->right, k);
}

Node* Tree::Successor(Node* x) {
	if(x->right != NULL) return Max(x->right);
	else {
		Node* y = x->parent;

		while(y != NULL && x != y->right) {
			x = y;
			y = y->parent;
		}
		return y;
	}
}

void Tree::Clear(Node* x) {
	if(x != NULL) {
		Clear(x->left);
		Clear(x->right);
		delete x;
	}
}

void Tree::Insert(Node *InsertNode) {
	Node *y = NULL;
	Node *x = Root;
	while( x != NULL ) {
		y = x;
		if( InsertNode->key < x->key ) {
			x = x->left;
		} else {
			x = x->right;
		}
	}
 
	InsertNode->parent = y;
	if( y == NULL ) {
	Root = InsertNode;
	} else {
		if(InsertNode->key < y->key) {
			y->left = InsertNode;
		} else {
			y->right = InsertNode;
		}
	}
}

void Tree::Delete(Node* DeleteNode ) {
	Node *y = NULL;
	Node *x = NULL;
 
	if( (DeleteNode->left == NULL) || (DeleteNode->right == NULL) ) y = DeleteNode;
	else y = Successor(DeleteNode);
 
	if( y->left != NULL ) x = y->left;
	else x = y->right;
	 
	if( x != NULL ) x->parent = y->parent;
 
	if( y->parent == NULL ) Root = x;
	else {
		if(y == y->parent->left) y->parent->left = x;
		else y->parent->right = x;
	}
 
	if( y != DeleteNode ) DeleteNode->key = y->key;
 
	delete y;
	y = NULL;
}
 
Tree::~Tree(void) {
	Clear(Root);
}
